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

// Load data from JSON file
async function loadData() {
    try {
        // Show loading state
        companyGrid.innerHTML = '<div class="loading"><i class="fas fa-spinner"></i>Loading companies...</div>';
        
        const response = await fetch('./data/extractedJSON.json');
        if (!response.ok) {
            throw new Error('Failed to load data');
        }
        companyData = await response.json();
        renderCompanyGrid();
    } catch (error) {
        console.error('Error loading data:', error);
        companyGrid.innerHTML = '<div class="empty-state"><i class="fas fa-exclamation-triangle"></i><h3>Error loading data</h3><p>Please make sure the data/extractedJSON.json file exists.</p></div>';
    }
}

// Setup event listeners
function setupEventListeners() {
    // Search input
    companySearch.addEventListener('input', handleSearch);
    companySearch.addEventListener('focus', handleSearchFocus);
    
    // Close search results when clicking outside
    document.addEventListener('click', function(e) {
        if (!e.target.closest('.search-container')) {
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
        companyGrid.innerHTML = '<div class="empty-state"><i class="fas fa-building"></i><h3>No companies found</h3><p>No company data available.</p></div>';
        return;
    }
    
    companyGrid.innerHTML = companies.map(company => {
        const problemCount = companyData[company].length;
        return `
            <div class="company-card" data-company="${company}" onclick="selectCompany('${company}')">
                <h3>${company}</h3>
                <div class="problem-count">${problemCount} problem${problemCount !== 1 ? 's' : ''}</div>
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
            <div class="search-result-item" onclick="selectCompanyFromSearch('${company}')">
                <div>${highlightedName}</div>
                <div class="company-count">${problemCount} problem${problemCount !== 1 ? 's' : ''}</div>
            </div>
        `;
    }).join('');
    
    searchResults.innerHTML = resultsHTML;
    searchResults.classList.add('show');
}

// Show no results message
function showNoResults() {
    searchResults.innerHTML = '<div class="search-result-item">No companies found</div>';
    searchResults.classList.add('show');
}

// Hide search results
function hideSearchResults() {
    searchResults.classList.remove('show');
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
    
    // Update visual selection
    document.querySelectorAll('.company-card').forEach(card => {
        card.classList.remove('selected');
    });
    
    const selectedCard = document.querySelector(`[data-company="${company}"]`);
    if (selectedCard) {
        selectedCard.classList.add('selected');
    }
    
    // Update heading
    selectedCompanyHeading.innerHTML = `<i class="fas fa-code" style="font-size: 0.8em;"></i> ${company} Problems`;

    
    // Render problems
    renderProblems(companyData[company]);
    
    // Show problems section
    problemsSection.style.display = 'block';
    
    // Smooth scroll to problems section
    setTimeout(() => {
        problemsSection.scrollIntoView({ behavior: 'smooth', block: 'start' });
    }, 100);
}

// Render problems table
function renderProblems(problems) {
    if (!problems || problems.length === 0) {
        problemsBody.innerHTML = '<tr><td colspan="6" class="empty-state">No problems found for this company.</td></tr>';
        return;
    }
    
    problemsBody.innerHTML = problems.map((problem, index) => {
        const leetcodeLink = createLinkHTML(problem.leetcode_link, 'LeetCode', 'problem-link');
        const solutionLink = createLinkHTML(problem.solution_yt_link, 'Solution', 'solution-link');
        const keySteps = formatKeySteps(problem.key_steps);
        
        return `
            <tr>
                <td>${problem.leetcode_number !== 'N/A' ? problem.leetcode_number : index + 1}</td>
                <td><strong>${escapeHtml(problem.problem_name)}</strong></td>
                <td>${leetcodeLink}</td>
                <td>${solutionLink}</td>
                <td><div class="intuition-text">${escapeHtml(problem.intuition)}</div></td>
                <td><div class="key-steps-text">${keySteps}</div></td>
            </tr>
        `;
    }).join('');
}

// Create link HTML
function createLinkHTML(url, text, className) {
    if (!url || url === 'N/A' || url.trim() === '') {
        return '<span class="na-text">N/A</span>';
    }
    
    // Extract actual URL from markdown-style links
    const markdownLinkMatch = url.match(/\[.*?\]\((https?:\/\/.*?)\)/);
    const actualUrl = markdownLinkMatch ? markdownLinkMatch[1] : url;
    
    // Validate URL
    try {
        new URL(actualUrl);
        return `<a href="${actualUrl}" target="_blank" rel="noopener noreferrer" class="${className}">${text}</a>`;
    } catch (e) {
        return '<span class="na-text">Invalid URL</span>';
    }
}

// Format key steps
function formatKeySteps(steps) {
    if (!steps || steps === 'N/A') {
        return '<span class="na-text">N/A</span>';
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