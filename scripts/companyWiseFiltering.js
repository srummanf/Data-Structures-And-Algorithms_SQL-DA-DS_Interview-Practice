// Global variables
        let companyData = {};
        let currentCompany = null;

        // DOM Elements
        const companySearch = document.getElementById('companySearch');
        const searchResults = document.getElementById('searchResults');
        const companyGrid = document.getElementById('companyGrid');
        const problemsSection = document.getElementById('problemsSection');
        const selectedCompanyHeading = document.getElementById('selectedCompany');
        const problemsBody = document.getElementById('problemsBody');

        // Initialize the application
        document.addEventListener('DOMContentLoaded', function() {
            loadData();
            setupEventListeners();
        });

        // Load data from JSON files
        async function loadData() {
            try {
                // Show loading state
                companyGrid.innerHTML = '<div class="col-span-full text-center py-10 text-xl text-gray-600"><i class="fas fa-spinner animate-spin mr-2"></i>Loading companies...</div>';
                
                // Load primary data (parsedCompanyTagsFromMyPractice.json)
                const primaryResponse = await fetch('../data/parsedCompanyTagsFromMyPractice.json');
                if (!primaryResponse.ok) {
                    throw new Error('Failed to load primary data');
                }
                companyData = await primaryResponse.json();
                
                // Load secondary data (companyTags.json) and merge
                try {
                    const secondaryResponse = await fetch('../data/companyTags.json');
                    if (secondaryResponse.ok) {
                        const companyTagsData = await secondaryResponse.json();
                        mergeCompanyData(companyTagsData);
                        console.log('Successfully loaded and merged company tags data');
                    } else {
                        console.log('Company tags data not found, using only primary data');
                    }
                } catch (secondaryError) {
                    console.log('Company tags data not available, using only primary data:', secondaryError.message);
                }
                
                renderCompanyGrid();
            } catch (error) {
                console.error('Error loading data:', error);
                companyGrid.innerHTML = '<div class="col-span-full text-center py-10"><i class="fas fa-exclamation-triangle text-3xl mb-4 text-gray-400 block"></i><h3 class="text-xl font-semibold text-gray-600 mb-2">Error loading data</h3><p class="text-gray-500">Please make sure the data/extractedJSON.json file exists.</p></div>';
            }
        }

        // Merge company tags data with existing data, avoiding duplicates
        function mergeCompanyData(companyTagsData) {
            Object.keys(companyTagsData).forEach(company => {
                const newProblems = companyTagsData[company];
                
                if (!companyData[company]) {
                    // Company doesn't exist in primary data, add all problems
                    companyData[company] = newProblems;
                    console.log(`Added new company: ${company} with ${newProblems.length} problems`);
                } else {
                    // Company exists, add only non-duplicate problems
                    const existingProblems = companyData[company];
                    const existingProblemKeys = new Set();
                    
                    // Create a set of existing problem identifiers
                    existingProblems.forEach(problem => {
                        // Use multiple identifiers to detect duplicates
                        const key1 = `${problem.problem_name?.toLowerCase()}`;
                        const key2 = `${problem.leetcode_number}`;
                        const key3 = `${problem.problem_name?.toLowerCase()}_${problem.leetcode_number}`;
                        
                        existingProblemKeys.add(key1);
                        existingProblemKeys.add(key2);
                        existingProblemKeys.add(key3);
                    });
                    
                    // Filter out duplicates from new problems
                    const uniqueNewProblems = newProblems.filter(problem => {
                        const key1 = `${problem.problem_name?.toLowerCase()}`;
                        const key2 = `${problem.leetcode_number}`;
                        const key3 = `${problem.problem_name?.toLowerCase()}_${problem.leetcode_number}`;
                        
                        // Check if any of the keys already exist
                        const isDuplicate = existingProblemKeys.has(key1) || 
                                          existingProblemKeys.has(key2) || 
                                          existingProblemKeys.has(key3);
                        
                        if (isDuplicate) {
                            console.log(`Skipping duplicate problem: ${problem.problem_name} (${problem.leetcode_number}) for ${company}`);
                            return false;
                        }
                        
                        return true;
                    });
                    
                    // Add unique new problems to existing company data
                    if (uniqueNewProblems.length > 0) {
                        companyData[company] = [...existingProblems, ...uniqueNewProblems];
                        console.log(`Added ${uniqueNewProblems.length} new problems to existing company: ${company}`);
                    } else {
                        console.log(`No new unique problems found for company: ${company}`);
                    }
                }
            });
        }

        // Setup event listeners
        function setupEventListeners() {
            // Search input
            companySearch.addEventListener('input', handleSearch);
            companySearch.addEventListener('focus', handleSearchFocus);
            
            // Close search results when clicking outside
            document.addEventListener('click', function(e) {
                if (!e.target.closest('.relative')) {
                    hideSearchResults();
                }
            });
            
            // Handle escape key to close search
            document.addEventListener('keydown', function(e) {
                if (e.key === 'Escape') {
                    hideSearchResults();
                    companySearch.blur();
                }
            });
        }

        // Render company grid
        function renderCompanyGrid() {
            const companies = Object.keys(companyData);
            
            if (companies.length === 0) {
                companyGrid.innerHTML = '<div class="col-span-full text-center py-10"><i class="fas fa-building text-3xl mb-4 text-gray-400 block"></i><h3 class="text-xl font-semibold text-gray-600 mb-2">No companies found</h3><p class="text-gray-500">No company data available.</p></div>';
                return;
            }
            
            companyGrid.innerHTML = companies.map(company => {
                const problemCount = companyData[company].length;
                return `
                    <div class="company-card bg-custom-green border-[0.25rem] border-black rounded-xl p-5 text-center  transition-all duration-200 shadow-[0.25rem_0.25rem_0px_#222] relative overflow-hidden hover:-translate-x-[0.15rem] hover:-translate-y-[0.15rem] hover:shadow-[0.4rem_0.4rem_0px_#222]" 
                         data-company="${company}" 
                         onclick="selectCompany('${company}')">
                        <h3 class="text-lg md:text-xl font-semibold mb-2 font-space">${company}</h3>
                        <div class="text-sm opacity-80 font-medium">${problemCount} problem${problemCount !== 1 ? 's' : ''}</div>
                    </div>
                `;
            }).join('');
        }

        // Handle search input
        function handleSearch(e) {
            const query = e.target.value.trim().toLowerCase();
            
            if (query === '') {
                hideSearchResults();
                return;
            }
            
            const companies = Object.keys(companyData);
            const filteredCompanies = companies.filter(company =>
                company.toLowerCase().includes(query)
            );
            
            if (filteredCompanies.length > 0) {
                showSearchResults(filteredCompanies, query);
            } else {
                showNoResults();
            }
        }

        // Handle search focus
        function handleSearchFocus(e) {
            if (e.target.value.trim() !== '') {
                handleSearch(e);
            }
        }

        // Show search results
        function showSearchResults(companies, query) {
            const resultsHTML = companies.map(company => {
                const problemCount = companyData[company].length;
                const highlightedName = highlightMatch(company, query);
                return `
                    <div class="px-5 py-3  border-b-2 border-gray-200 text-lg font-medium transition-all duration-200 hover:bg-custom-purple hover:text-white last:border-b-0" onclick="selectCompanyFromSearch('${company}')">
                        <div>${highlightedName}</div>
                        <div class="text-sm text-gray-600 font-normal hover-parent-hover:text-white">${problemCount} problem${problemCount !== 1 ? 's' : ''}</div>
                    </div>
                `;
            }).join('');
            
            searchResults.innerHTML = resultsHTML;
            searchResults.classList.remove('hidden');
        }

        // Show no results message
        function showNoResults() {
            searchResults.innerHTML = '<div class="px-5 py-3 text-lg font-medium text-gray-600">No companies found</div>';
            searchResults.classList.remove('hidden');
        }

        // Hide search results
        function hideSearchResults() {
            searchResults.classList.add('hidden');
        }

        // Highlight matching text
        function highlightMatch(text, query) {
            const regex = new RegExp(`(${escapeRegExp(query)})`, 'gi');
            return text.replace(regex, '<strong>$1</strong>');
        }

        // Escape special regex characters
        function escapeRegExp(string) {
            return string.replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
        }

        // Select company from search
        function selectCompanyFromSearch(company) {
            companySearch.value = company;
            hideSearchResults();
            selectCompany(company);
        }

        // Select company
        function selectCompany(company) {
            currentCompany = company;
            
            // Update visual selection - Remove selected state from all cards
            document.querySelectorAll('.company-card').forEach(card => {
                card.classList.remove('bg-custom-purple', 'text-white', 'selected');
                card.classList.add('bg-custom-green');
                card.classList.remove('!-translate-x-[0.15rem]', '!-translate-y-[0.15rem]', '!shadow-[0.4rem_0.4rem_0px_#ff5400]');
            });
            
            // Add selected state to clicked card
            const selectedCard = document.querySelector(`[data-company="${company}"]`);
            if (selectedCard) {
                selectedCard.classList.remove('bg-custom-green');
                selectedCard.classList.add('bg-custom-purple', 'text-white', 'selected', '!-translate-x-[0.15rem]', '!-translate-y-[0.15rem]', '!shadow-[0.4rem_0.4rem_0px_#ff5400]');
            }
            
            // Update heading
            selectedCompanyHeading.innerHTML = `<i
            class="fas fa-code absolute -top-3 -left-3 bg-custom-orange text-2xl md:text-3xl h-14 w-14 border-4 border-black flex justify-center items-center rounded-md shadow-lg"
          ></i> ${company} Problems`;
            
            // Render problems
            renderProblems(companyData[company]);
            
            // Show problems section
            problemsSection.classList.remove('hidden');
            
            // Smooth scroll to problems section
            setTimeout(() => {
                problemsSection.scrollIntoView({ behavior: 'smooth', block: 'start' });
            }, 100);
        }

        // Toggle blur for intuition/key steps
        function toggleBlur(element, type) {
            const content = element.querySelector('.blurred-content');
            const overlay = element.querySelector('.blur-overlay');
            
            if (content && overlay) {
                // Remove blur and overlay
                content.classList.remove('blur-sm');
                overlay.remove();
                element.classList.remove('relative', 'cursor-pointer');
                element.removeAttribute('onclick');
            }
        }

        // Render problems table
        function renderProblems(problems) {
            if (!problems || problems.length === 0) {
                problemsBody.innerHTML = '<tr><td colspan="6" class="text-center py-10 text-gray-600">No problems found for this company.</td></tr>';
                return;
            }
            
            problemsBody.innerHTML = problems.map((problem, index) => {
                const leetcodeLink = createLinkHTML(problem.leetcode_link, 'LeetCode', 'inline-block px-3 py-2 bg-custom-orange text-white no-underline rounded-lg font-medium text-sm border-[0.12rem] border-black shadow-[0.12rem_0.12rem_0px_black] transition-all duration-200 hover:-translate-x-[0.06rem] hover:-translate-y-[0.06rem] hover:shadow-[0.18rem_0.18rem_0px_black]');
                const solutionLink = createLinkHTML(problem.solution_yt_link, 'Solution', 'inline-block px-3 py-2 bg-custom-purple text-white no-underline rounded-lg font-medium text-sm border-[0.12rem] border-black shadow-[0.12rem_0.12rem_0px_black] transition-all duration-200 hover:-translate-x-[0.06rem] hover:-translate-y-[0.06rem] hover:shadow-[0.18rem_0.18rem_0px_black]');
                const keySteps = formatKeySteps(problem.key_steps);
                
                // Generate unique IDs for each cell
                const intuitionId = `intuition-${index}`;
                const keyStepsId = `keysteps-${index}`;
                
                return `
                    <tr class="hover:bg-blue-50 even:bg-gray-50 even:hover:bg-blue-50">
                        <td class="p-3 text-sm align-top border-b border-gray-300">${problem.leetcode_number !== 'N/A' ? problem.leetcode_number : index + 1}</td>
                        <td class="p-3 text-sm align-top border-b border-gray-300"><strong>${escapeHtml(problem.problem_name)}</strong></td>
                        <td class="p-3 text-sm align-top border-b border-gray-300">${leetcodeLink}</td>
                        <td class="p-3 text-sm align-top border-b border-gray-300">${solutionLink}</td>
                        <td class="p-3 text-sm align-middle border-b border-gray-300 max-w-[18.75rem] leading-6 relative  group" 
                            id="${intuitionId}" 
                            onclick="toggleBlur(this, 'intuition')">
                            <div class="blurred-content blur-sm transition-all duration-300">${escapeHtml(problem.intuition)}</div>
                            <div class="blur-overlay absolute inset-0 flex items-center justify-center bg-blue-100 bg-opacity-70 rounded">
                                <div class="text-center">
                                    <i class="fas fa-eye-slash text-blue-600 text-lg mb-1 block group-hover:hidden"></i>
                                    <i class="fas fa-eye text-blue-600 text-lg mb-1 hidden group-hover:block"></i>
                                    <div class="text-xs text-blue-700 font-medium hidden group-hover:block">Click to view</div>
                                </div>
                            </div>
                        </td>
                        <td class="p-3 text-sm align-middle border-b border-gray-300 max-w-[18.75rem] leading-6 whitespace-pre-line relative  group" 
                            id="${keyStepsId}" 
                            onclick="toggleBlur(this, 'keysteps')">
                            <div class="blurred-content blur-sm transition-all duration-300">${keySteps}</div>
                            <div class="blur-overlay absolute inset-0 flex items-center justify-center bg-blue-100 bg-opacity-70 rounded">
                                <div class="text-center">
                                    <i class="fas fa-eye-slash text-blue-600 text-lg mb-1 block group-hover:hidden"></i>
                                    <i class="fas fa-eye text-blue-600 text-lg mb-1 hidden group-hover:block"></i>
                                    <div class="text-xs text-blue-700 font-medium hidden group-hover:block">Click to view</div>
                                </div>
                            </div>
                        </td>
                    </tr>
                `;
            }).join('');
        }

        // Create link HTML
        function createLinkHTML(url, text, className) {
            if (!url || url === 'N/A' || url.trim() === '') {
                return '<span class="text-gray-600 italic text-sm">N/A</span>';
            }
            
            // Extract actual URL from markdown-style links
            const markdownLinkMatch = url.match(/\[.*?\]\((https?:\/\/.*?)\)/);
            const actualUrl = markdownLinkMatch ? markdownLinkMatch[1] : url;
            
            // Validate URL
            try {
                new URL(actualUrl);
                return `<a href="${actualUrl}" target="_blank" rel="noopener noreferrer" class="${className}">${text}</a>`;
            } catch (e) {
                return '<span class="text-gray-600 italic text-sm">Invalid URL</span>';
            }
        }

        // Format key steps
        function formatKeySteps(steps) {
            if (!steps || steps === 'N/A') {
                return '<span class="text-gray-600 italic text-sm">N/A</span>';
            }
            
            // Convert bullet points and clean up formatting
            let formatted = steps
                .replace(/- /g, '• ')
                .replace(/\. /g, '.\n')
                .trim();
            
            return escapeHtml(formatted);
        }

        // Escape HTML to prevent XSS
        function escapeHtml(text) {
            if (!text) return '';
            const div = document.createElement('div');
            div.textContent = text;
            return div.innerHTML;
        }

        // Utility function to get problem count for a company
        function getProblemCount(company) {
            return companyData[company] ? companyData[company].length : 0;
        }

        // Export functions for potential external use
        window.LeetCodeCompanyTags = {
            selectCompany,
            getCurrentCompany: () => currentCompany,
            getCompanyData: () => companyData,
            getProblemCount
        };