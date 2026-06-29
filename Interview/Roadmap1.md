



---
title: The Ultimate Company-Wise DSA Roadmap (2026)
source: https://jugaldb.notion.site/Company-Wise-DSA-patterns-26caf2117b83808eb7b2efae6afd15dc#26caf2117b8380e98d86d49a9fb757f0
---

## Part 1 LeetCode Links by Company & Pattern

> Curated problem links to practice the most asked patterns per company. All links are to LeetCode problem pages.

### Amazon

**Sliding Window**

- Longest Substring Without Repeating Characters
- Minimum Size Subarray Sum
- Minimum Window Substring
- Sliding Window Maximum

**Two Pointers**

- Two Sum II - Input Array Is Sorted
- Container With Most Water
- Trapping Rain Water
- Sort Colors (DNF)

**DFS**

- Rotting Oranges
- Shortest Path in Binary Matrix
- Word Ladder
- As Far from Land as Possible

**Design Data Structure**

- LRU Cache
- LFU Cache
- Design Browser History
- Snapshot Array

---

### Google

**Dynamic Programming**

- Longest Increasing Subsequence
- Edit Distance
- Coin Change
- Distinct Subsequences

**Graphs**

- Course Schedule
- Network Delay Time
- Cheapest Flights Within K Stops
- Accounts Merge

**Backtracking**

- N-Queens
- Sudoku Solver
- Word Search
- Palindrome Partitioning

**Modified Binary Search**

- Search in Rotated Sorted Array
- Find Minimum in Rotated Sorted Array
- Koko Eating Bananas
- Capacity to Ship Packages Within D Days
- Median of Two Sorted Arrays

---

### Meta

**Sliding Window**

- Longest Substring Without Repeating Characters
- Minimum Window Substring
- Permutation in String

**Trees**

- Binary Tree Level Order Traversal
- Binary Tree Zigzag Level Order Traversal
- Binary Tree Maximum Path Sum
- All Nodes Distance K in Binary Tree

**BFS**

- Word Ladder
- Rotting Oranges
- As Far from Land as Possible

**Design Data Structure**

- LRU Cache
- Design Twitter
- Design Browser History

---

### Netflix

**Overlapping Intervals**

- Merge Intervals
- Insert Interval
- Non-overlapping Intervals
- Minimum Number of Arrows to Burst Balloons

**Greedy**

- Jump Game II
- Gas Station
- Boats to Save People
- Candy

**Top K Elements**

- Top K Frequent Elements
- Kth Largest Element in an Array
- K Closest Points to Origin

**Two Heaps**

- Find Median from Data Stream
- Sliding Window Median

---

### Uber

**Graphs**

- Cheapest Flights Within K Stops
- Network Delay Time
- Redundant Connection
- Accounts Merge

**Greedy**

- Car Pooling
- Jump Game II
- Gas Station

**Two Heaps**

- IPO
- Find Median from Data Stream

**Top K Elements**

- K Closest Points to Origin
- Kth Largest Element in an Array
- Top K Frequent Elements

---

### Airbnb

**Overlapping Intervals**

- Merge Intervals
- Insert Interval
- Minimum Number of Arrows to Burst Balloons

**BFS**

- Shortest Path in Binary Matrix
- As Far from Land as Possible

**Backtracking**

- Combination Sum
- Generate Parentheses
- Word Search
- Palindrome Partitioning

**Design Data Structure**

- LRU Cache
- Design Twitter
- Snapshot Array

---

### Microsoft

**Trees**

- Validate Binary Search Tree
- Lowest Common Ancestor of a Binary Tree
- Diameter of Binary Tree

**Dynamic Programming**

- Longest Common Subsequence
- Edit Distance
- Partition Equal Subset Sum

**Bitwise XOR**

- Missing Number
- Single Number
- Single Number III

**Modified Binary Search**

- Single Element in a Sorted Array
- Find Peak Element

---

### Apple

**Modified Binary Search**

- Search in Rotated Sorted Array
- Median of Two Sorted Arrays

**Two Pointers**

- Container With Most Water
- Trapping Rain Water

**Monotonic Stack**

- Daily Temperatures
- Largest Rectangle in Histogram

**Matrix Manipulation**

- Rotate Image
- Set Matrix Zeroes
- Spiral Matrix
- Game of Life

## Part 2 Company → Core Patterns

- **Amazon:** Sliding Window (4), Two Pointers (5), BFS (9), Design Data Structure (22)
- **Google:** Dynamic Programming (19), Graphs (20), Backtracking (11), Modified Binary Search (12)
- **Meta:** Sliding Window (4), Trees (18), BFS (9), Design Data Structure (22)
- **Netflix:** Overlapping Intervals (2), Greedy (21), Top K Elements (14), Two Heaps (16)
- **Uber:** Graphs (20), Greedy (21), Two Heaps (16), Top K Elements (14)
- **Airbnb:** Overlapping Intervals (2), BFS (9), Backtracking (11), Design Data Structure (22)
- **Microsoft:** Trees (18), Dynamic Programming (19), Bitwise XOR (13), Modified Binary Search (12)
- **Apple:** Modified Binary Search (12), Two Pointers (5), Monotonic Stack (17), Matrix Manipulation (8)

---

## Part 3 Core DSA Patterns

After solving lots of DSA problems, here are key patterns that matter for interviews. Each pattern lists representative problems.

1. **Fast & Slow Pointer**

   Detect cycles, find middle, palindromes.

   *Linked List Cycle II* · *Remove Nth Node from End of List* · *Find the Duplicate Number* · *Palindrome Linked List*
2. **Overlapping Intervals**

   Sort/merge by start/end.

   *Merge Intervals* · *Insert Interval* · *My Calendar II* · *Minimum Number of Arrows to Burst Balloons* · *Non-overlapping Intervals*
3. **Prefix Sum**

   Cumulative sums/products for range queries.

   *Find the Middle Index in Array* · *Product of Array Except Self* · *Maximum Product Subarray* · *Number of Ways to Split Array* · *Range Sum Query 2D*
4. **Sliding Window**

   Move a subarray/substring, often O(n).

   **Fixed Size:** *Maximum Sum Subarray of Size K* · *Number of Subarrays with Average ≥ Threshold* · *Repeated DNA Sequences* · *Permutation in String* · *Sliding Subarray Beauty* · *Sliding Window Maximum*

   **Variable Size:** *Longest Substring Without Repeating Characters* · *Minimum Size Subarray Sum* · *Subarray Product Less Than K* · *Max Consecutive Ones* · *Fruits Into Baskets* · *Count Number of Nice Subarrays* · *Minimum Window Substring*
5. **Two Pointers**

   Two indices advancing at different rates.

   *Two Sum II (Sorted)* · *Sort Colors (DNF)* · *Next Permutation* · *Bag of Tokens* · *Container With Most Water* · *Trapping Rain Water*
6. **Cyclic Sort (Index-Based)**

   Consecutive ranges placed at correct indexes.

   *Missing Number* · *Find All Numbers Disappeared in an Array* · *Set Mismatch* · *First Missing Positive*
7. **Reverse Linked List (In-place)**

   In-place list manipulations.

   *Reverse Linked List* · *Reverse Nodes in k-Group* · *Swap Nodes in Pairs*
8. **Matrix Manipulation**

   2D traversal / transforms.

   *Rotate Image* · *Spiral Matrix* · *Set Matrix Zeroes* · *Game of Life*
9. **Breadth-First Search (BFS)**

   Level-order via queue, shortest paths.

   *Shortest Path in Binary Matrix* · *Rotting Oranges* · *As Far from Land as Possible* · *Word Ladder*
10. **Depth-First Search (DFS)**

    Deep exploration + backtrack.

    *Number of Closed Islands* · *Coloring a Border* · *Number of Enclaves* · *Time Needed to Inform All Employees* · *Find Eventual Safe States*
11. **Backtracking**

    Explore all potential candidates.

    *Permutations II* · *Combination Sum* · *Generate Parentheses* · *N-Queens* · *Sudoku Solver* · *Palindrome Partitioning* · *Word Search*
12. **Modified Binary Search**

    Variants on rotated/specialized arrays.

    *Search in Rotated Sorted Array* · *Find Minimum in Rotated Sorted Array* · *Find Peak Element* · *Single Element in a Sorted Array* · *Minimum Speed to Arrive on Time* · *Capacity to Ship Packages within D Days* · *Koko Eating Bananas* · *Find in Mountain Array* · *Median of Two Sorted Arrays*
13. **Bitwise XOR**

    Pairing/cancellation tricks.

    *Missing Number* · *Single Number II* · *Single Number III* · *Find the Original Array of Prefix XOR* · *XOR Queries of a Subarray*
14. **Top K Elements**

    Heaps / quickselect.

    *Top K Frequent Elements* · *Kth Largest Element in an Array* · *Ugly Number II* · *K Closest Points to Origin*
15. **K-way Merge**

    Heap to merge multiple sorted inputs.

    *Find K Pairs with Smallest Sums* · *Kth Smallest Element in a Sorted Matrix* · *Merge K Sorted Lists* · *Smallest Range Covering Elements from K Lists*
16. **Two Heaps**

    Maintain dynamic medians/extremes.

    *Find Median from Data Stream* · *Sliding Window Median* · *IPO*
17. **Monotonic Stack**

    Range queries via inc/dec stack.

    *Next Greater Element II* · *Next Greater Node in Linked List* · *Daily Temperatures* · *Online Stock Span* · *Maximum Width Ramp* · *Largest Rectangle in Histogram*
18. **Trees**

    **Level Order (BFS in Trees):** *Level Order Traversal* · *Zigzag Level Order* · *Even Odd Tree* · *Reverse Odd Levels* · *Deepest Leaves Sum* · *All Nodes Distance K in Binary Tree* · *Maximum Width of Binary Tree* · *Add One Row to Tree*

    **Construction:** *Construct BT from Preorder & Inorder* · *Construct BT from Postorder & Inorder* · *Maximum Binary Tree* · *Construct BST from Preorder*

    **Height-related:** *Maximum Depth* · *Balanced Binary Tree* · *Diameter of Binary Tree* · *Minimum Depth*

    **Root-to-Leaf Paths:** *Binary Tree Paths* · *Path Sum II* · *Sum Root to Leaf Numbers* · *Smallest String Starting from Leaf* · *Insufficient Nodes in Root to Leaf Paths* · *Pseudo-Palindromic Paths in a Binary Tree* · *Binary Tree Maximum Path Sum*

    **Ancestor:** *LCA of Binary Tree* · *Maximum Difference Between Node and Ancestor* · *LCA of Deepest Leaves* · *Kth Ancestor of a Tree Node*
19. **Dynamic Programming (DP)**

    **Take/Not Take (0/1 style):** *House Robber II* · *Target Sum* · *Partition Equal Subset Sum* · *Ones and Zeroes* · *Last Stone Weight II*

    **Unbounded (Coin-change style):** *Coin Change* · *Coin Change II* · *Perfect Squares* · *Minimum Cost For Tickets*

    **LIS family:** *Longest Increasing Subsequence* · *Largest Divisible Subset* · *Maximum Length of Pair Chain* · *Number of LIS* · *Longest String Chain*

    **DP on Grids:** *Unique Paths II* · *Minimum Path Sum* · *Triangle* · *Minimum Falling Path Sum* · *Maximal Square* · *Cherry Pickup* · *Dungeon Game*

    **DP on Strings:** *Longest Common Subsequence* · *Longest Palindromic Subsequence* · *Palindromic Substrings* · *Longest Palindromic Substring* · *Edit Distance* · *Minimum ASCII Delete Sum for Two Strings* · *Distinct Subsequences* · *Shortest Common Supersequence* · *Wildcard Matching*

    **DP on Stocks:** *Best Time to Buy and Sell Stock II/III/IV* · *With Cooldown* · *With Transaction Fee*

    **Partition DP (MCM):** *Partition Array for Maximum Sum* · *Burst Balloons* · *Minimum Cost to Cut a Stick* · *Palindrome Partitioning II*
20. **Graphs**

    **Topological Sort:** *Course Schedule* · *Course Schedule II* · *Strange Printer II* · *Sequence Reconstruction*

    **Union-Find:** *Number of Operations to Make Network Connected* · *Redundant Connection* · *Accounts Merge* · *Satisfiability of Equality Equations*

    **Algorithms:** *Minimum Cost to Connect All Points (Kruskal)* · *Cheapest Flights Within K Stops (Dijkstra/BFS)* · *Find the City With the Smallest Number of Neighbors at a Threshold Distance (Floyd–Warshall)* · *Network Delay Time (Bellman–Ford/Dijkstra)*
21. **Greedy**

    *Jump Game II* · *Gas Station* · *Bag of Tokens* · *Boats to Save People* · *Wiggle Subsequence* · *Car Pooling* · *Candy*
22. **Design Data Structure**

    Custom DS for ops/updates/memory.

    *Design Twitter* · *Design Browser History* · *Design Circular Deque* · *Snapshot Array* · *LRU Cache* · *LFU Cache*

