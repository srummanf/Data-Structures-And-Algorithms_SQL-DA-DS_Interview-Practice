// Data & state
let SHEET_DATA = {};
let currentTab = "ds";
let progress = {};
let starred = {};

// Tab configuration
const TAB_CONFIG = {
  ds: {
    name: "Data Structures",
    dataFile: "../data/sheet_DS.json",
    icon: "fa-sitemap"
  },
  algo: {
    name: "Algorithms", 
    dataFile: "../data/sheet_A.json",
    icon: "fa-code-branch"
  },
  striver: {
    name: "Striver SDE Sheet",
    dataFile: "../data/StriverSDESheet.json", 
    icon: "fa-list-check"
  },
  neetcode: {
    name: "NeetCode 85 Sheet",
    dataFile: "../data/NeetCode75.json",
    icon: "fa-code"
  }
};

// Active filters
const filters = { star: "all", done: "all", difficulty: "all" };

// Load all JSON files
document.addEventListener("DOMContentLoaded", async () => {
  // Load progress and starred data from localStorage
  progress = JSON.parse(localStorage.getItem("dsaProgress") || "{}");
  starred = JSON.parse(localStorage.getItem("dsaStarred") || "{}");

  try {
    // Load all data sources
    const loadPromises = Object.entries(TAB_CONFIG).map(async ([tabKey, config]) => {
      try {
        const response = await fetch(config.dataFile);
        if (response.ok) {
          const data = await response.json();
          SHEET_DATA[tabKey] = data;
        } else {
          console.warn(`Failed to load ${config.name} data`);
          SHEET_DATA[tabKey] = {};
        }
      } catch (error) {
        console.warn(`Error loading ${config.name}:`, error);
        SHEET_DATA[tabKey] = {};
      }
    });

    await Promise.all(loadPromises);

    // Fix duplicate IDs by using links as unique identifiers
    preprocessSheetData();
    
    renderCurrentTab();
    initTabs();
    initFilters();
    updateStats();
  } catch (e) {
    console.error("Failed to load sheet data", e);
    // Initialize with empty data
    Object.keys(TAB_CONFIG).forEach(key => {
      SHEET_DATA[key] = {};
    });
    renderCurrentTab();
    initTabs();
    initFilters();
    updateStats();
  }
  setupPdf();
});

// Preprocess sheet data to ensure unique identifiers
function preprocessSheetData() {
  Object.keys(SHEET_DATA).forEach(tabKey => {
    const data = SHEET_DATA[tabKey];
    Object.keys(data).forEach(category => {
      if (Array.isArray(data[category])) {
        data[category].forEach(item => {
          // Use link as unique identifier, fallback to original id with prefix
          item.uniqueId = item.link || `${tabKey}_${category}_${item.id}`;
        });
      }
    });
  });

  // Migrate old localStorage data if it exists (based on old numeric IDs)
  migrateOldStorageData();
}

// Migrate old storage data to link-based system
function migrateOldStorageData() {
  const oldProgress = JSON.parse(localStorage.getItem("dsaProgress") || "{}");
  const oldStarred = JSON.parse(localStorage.getItem("dsaStarred") || "{}");
  
  // Only migrate if we have old numeric-based data
  const hasOldData = Object.keys(oldProgress).some(key => !isNaN(key)) || 
                     Object.keys(oldStarred).some(key => !isNaN(key));
  
  if (!hasOldData) return;

  const newProgress = {};
  const newStarred = {};

  // Helper function to find item by old ID
  const findItemByOldId = (oldId) => {
    for (const tabKey of Object.keys(SHEET_DATA)) {
      const data = SHEET_DATA[tabKey];
      for (const category of Object.keys(data)) {
        if (Array.isArray(data[category])) {
          const item = data[category].find(item => item.id == oldId);
          if (item) return item;
        }
      }
    }
    return null;
  };

  // Migrate progress data
  Object.keys(oldProgress).forEach(oldId => {
    if (!isNaN(oldId)) {
      const item = findItemByOldId(oldId);
      if (item && item.uniqueId) {
        newProgress[item.uniqueId] = oldProgress[oldId];
      }
    } else {
      // Keep non-numeric keys as they might already be links
      newProgress[oldId] = oldProgress[oldId];
    }
  });

  // Migrate starred data
  Object.keys(oldStarred).forEach(oldId => {
    if (!isNaN(oldId)) {
      const item = findItemByOldId(oldId);
      if (item && item.uniqueId) {
        newStarred[item.uniqueId] = oldStarred[oldId];
      }
    } else {
      // Keep non-numeric keys as they might already be links
      newStarred[oldId] = oldStarred[oldId];
    }
  });

  // Update global variables and localStorage
  progress = newProgress;
  starred = newStarred;
  localStorage.setItem("dsaProgress", JSON.stringify(progress));
  localStorage.setItem("dsaStarred", JSON.stringify(starred));
}

// Get current sheet data based on active tab
function getCurrentSheet() {
  return SHEET_DATA[currentTab] || {};
}

// Tab switching
function initTabs() {
  document.querySelectorAll("[data-tab]").forEach((btn) => {
    btn.addEventListener("click", () => {
      const tab = btn.dataset.tab;
      if (tab === currentTab) return;

      currentTab = tab;

      // Update tab button states
      document
        .querySelectorAll("[data-tab]")
        .forEach((b) => b.classList.remove("active"));
      btn.classList.add("active");

      // Update tab name in stats
      const tabConfig = TAB_CONFIG[tab];
      document.getElementById("currentTabName").textContent = tabConfig ? tabConfig.name : "Unknown";

      // Reset filters to default
      filters.star = "all";
      filters.done = "all";
      filters.difficulty = "all";
      document
        .querySelectorAll("[data-seg]")
        .forEach((b) => b.classList.remove("active"));
      document
        .querySelectorAll("[data-val='all']")
        .forEach((b) => b.classList.add("active"));

      renderCurrentTab();
      updateStats();
    });
  });
}

// Render current tab
function renderCurrentTab() {
  const data = getCurrentSheet();
  renderAll(data);
}

// Rendering
function renderAll(data) {
  const wrap = document.getElementById("sheetContainer");
  wrap.innerHTML = "";

  if (!data || Object.keys(data).length === 0) {
    const tabConfig = TAB_CONFIG[currentTab];
    wrap.innerHTML = `
      <div class="text-center py-12">
        <div class="bg-yellow-100 border-[0.4rem] border-black rounded-2xl p-6 shadow-brutalSm inline-block">
          <i class="fa-solid fa-exclamation-triangle text-4xl text-custom-orange mb-4"></i>
          <p class="font-space text-xl font-bold mb-2">No Data Available</p>
          <p class="text-gray-700">The ${tabConfig ? tabConfig.name : "selected"} data file could not be loaded.</p>
        </div>
      </div>
    `;
    return;
  }

  Object.keys(data).forEach((category) => {
    const list = data[category] || [];
    if (!Array.isArray(list)) return;
    
    const filteredList = list.filter((q) => {
  const isStar = !!starred[q.uniqueId];
  const isDone = !!progress[q.uniqueId];

  const starOk =
    filters.star === "all" ||
    (filters.star === "starred" && isStar) ||
    (filters.star === "not-starred" && !isStar);

  const doneOk =
    filters.done === "all" ||
    (filters.done === "completed" && isDone) ||
    (filters.done === "not-completed" && !isDone);

  // NEW: Difficulty filter logic
  const difficultyOk =
    filters.difficulty === "all" ||
    (q.difficulty && q.difficulty.toLowerCase() === filters.difficulty);

  return starOk && doneOk && difficultyOk;
});

    if (filteredList.length === 0) return;

    const section = document.createElement("section");
    section.className = "space-y-3";

    section.innerHTML = `
      <h3 class="font-space text-xl md:text-2xl font-bold">${category}</h3>
      <div class="overflow-x-auto bg-custom-green border-[0.4rem] border-black rounded-2xl shadow-brutalSm">
        <table class="w-full border-collapse text-xs md:text-base">
          <thead class="sticky top-0">
            <tr>
              <th class="bg-custom-purple text-white p-2 md:p-3 text-left border-black">#</th>
              <th class="bg-custom-purple text-white p-2 md:p-3 text-left">Problem</th>
              <th class="bg-custom-purple text-white p-2 md:p-3">Difficulty</th>
              <th class="bg-custom-purple text-white p-2 md:p-3">Done</th>
              <th class="bg-custom-purple text-white p-2 md:p-3">Star</th>
            </tr>
          </thead>
          <tbody></tbody>
        </table>
      </div>
    `;

    const tbody = section.querySelector("tbody");
    filteredList.forEach((q, idx) => {
      const isDone = !!progress[q.uniqueId];
      const isStar = !!starred[q.uniqueId];
      const diffClass =
        q.difficulty?.toLowerCase() === "easy"
          ? "text-green-700"
          : q.difficulty?.toLowerCase() === "medium"
          ? "text-custom-orange"
          : "text-red-600";

      const tr = document.createElement("tr");
      tr.className = "border-b border-black bg-white/60 hover:bg-white";
      tr.innerHTML = `
        <td class="p-2 md:p-3 font-semibold">${idx + 1}</td>
        <td class="p-2 md:p-3">
          <a href="${q.link}" target="_blank"
             class="text-custom-purple font-semibold hover:underline break-words">${
               q.name
             }</a>
        </td>
        <td class="p-2 md:p-3 text-center font-bold ${diffClass}">${
          q.difficulty || "-"
        }</td>
        <td class="p-2 md:p-3 text-center">
          <input type="checkbox" data-unique-id="${q.uniqueId}" ${
            isDone ? "checked" : ""
          }
                 class="w-4 h-4 md:w-5 md:h-5 rounded" style="accent-color:#6c62ff">
        </td>
        <td class="p-2 md:p-3 text-center">
          <i class="fa-star ${
            isStar ? "fas starred" : "far"
          }  text-lg md:text-xl" data-star-unique-id="${q.uniqueId}"></i>
        </td>
      `;
      tbody.appendChild(tr);
    });

    wrap.appendChild(section);
  });

  attachRowHandlers();
}

function attachRowHandlers() {
  // Done checkbox handler
  document.querySelectorAll("input[type='checkbox'][data-unique-id]").forEach((cb) => {
    cb.addEventListener("change", (e) => {
      const uniqueId = e.target.dataset.uniqueId;
      if (e.target.checked) {
        progress[uniqueId] = true;
      } else {
        delete progress[uniqueId];
      }
      localStorage.setItem("dsaProgress", JSON.stringify(progress));
      updateStats();
    });
  });
  
  // Star handler
  document.querySelectorAll("i[data-star-unique-id]").forEach((icon) => {
    icon.addEventListener("click", (e) => {
      const uniqueId = e.target.dataset.starUniqueId;
      if (starred[uniqueId]) {
        delete starred[uniqueId];
        e.target.classList.remove("fas", "starred");
        e.target.classList.add("far");
      } else {
        starred[uniqueId] = true;
        e.target.classList.remove("far");
        e.target.classList.add("fas", "starred");
      }
      localStorage.setItem("dsaStarred", JSON.stringify(starred));
      updateStats();
    });
  });
}

// Filters UI
function initFilters() {
  document.querySelectorAll("[data-seg]").forEach((btn) => {
    btn.addEventListener("click", () => {
      const group = btn.dataset.seg;
      const val = btn.dataset.val;
      filters[group] = val;

      // toggle active styles
      document
        .querySelectorAll(`[data-seg="${group}"]`)
        .forEach((b) => b.classList.remove("active"));
      btn.classList.add("active");

      renderCurrentTab();
    });
  });
}

// Stats - Fixed calculation logic
function updateStats() {
  const data = getCurrentSheet();
  
  if (!data || Object.keys(data).length === 0) {
    // Handle empty data case
    document.getElementById("statTotal").textContent = 0;
    document.getElementById("statDone").textContent = 0;
    document.getElementById("statRemain").textContent = 0;
    document.getElementById("statStar").textContent = 0;
    
    const bar = document.getElementById("progressBar");
    bar.style.width = "0%";
    bar.textContent = "0%";
    return;
  }

  // Flatten all problems from current sheet
  const allProblems = [];
  Object.values(data).forEach(categoryData => {
    if (Array.isArray(categoryData)) {
      allProblems.push(...categoryData);
    }
  });
  
  const total = allProblems.length;
  
  // Count completed problems (using uniqueId)
  const completed = allProblems.filter(q => progress[q.uniqueId]).length;
  
  // Count starred problems (using uniqueId)  
  const starredCount = allProblems.filter(q => starred[q.uniqueId]).length;
  
  const remaining = Math.max(total - completed, 0);

  // Update DOM
  document.getElementById("statTotal").textContent = total;
  document.getElementById("statDone").textContent = completed;
  document.getElementById("statRemain").textContent = remaining;
  document.getElementById("statStar").textContent = starredCount;

  // Progress bar
  const percent = total > 0 ? Math.round((completed / total) * 100) : 0;
  const bar = document.getElementById("progressBar");
  bar.style.width = percent + "%";
  bar.textContent = percent + "%";
  
  // Debug logging (remove in production)
  console.log(`Stats Update - Tab: ${currentTab}, Total: ${total}, Completed: ${completed}, Starred: ${starredCount}, Progress: ${percent}%`);
}

// PDF (multi-page, with uniform margins)
function setupPdf() {
  document.getElementById("downloadBtn").addEventListener("click", async () => {
    const { jsPDF } = window.jspdf;
    const pdf = new jsPDF("p", "pt", "a4");

    const pageW = pdf.internal.pageSize.getWidth();
    const pageH = pdf.internal.pageSize.getHeight();
    const margin = 36; // 0.5in margin on all sides
    const usableW = pageW - margin * 2;
    const usableH = pageH - margin * 2;

    const node = document.getElementById("pdfArea");

    const canvas = await html2canvas(node, {
      scale: 2,
      backgroundColor: "#ffffff",
      useCORS: true,
    });
    const imgData = canvas.toDataURL("image/png");

    const imgW = usableW; // fit width
    const imgH = (canvas.height * imgW) / canvas.width; // scaled height

    let heightLeft = imgH;
    let position = margin;

    // first page
    pdf.addImage(imgData, "PNG", margin, position, imgW, imgH);
    heightLeft -= usableH;

    // overflow pages
    while (heightLeft > 0) {
      pdf.addPage();
      position = margin - (imgH - heightLeft);
      pdf.addImage(imgData, "PNG", margin, position, imgW, imgH);
      heightLeft -= usableH;
    }

    const tabConfig = TAB_CONFIG[currentTab];
    const tabName = tabConfig ? tabConfig.name.replace(/\s+/g, '-') : currentTab;
    pdf.save(`DSA-Sheet-${tabName}.pdf`);
  });
}