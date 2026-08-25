
# 20 Must-Know DSA Patterns

*Originally by Shivanjali Verma · 3 min read · [Medium Article](https://medium.com/@id.shivanjali/dsa-pattern-wise-roadmap-f92f38a9e83d)*

A list of 20 must-know DSA patterns with common use-cases and example problems.

---

## 1. Sliding Window

Expand the window to include elements, shrink when conditions break.

- **When to use:** Subarrays or substrings
- **Problems:** Longest Substring Without Repeating Characters, Minimum Window Substring, Maximum Sum Subarray of Size K

## 2. Two Pointers

Start pointers from opposite ends (or both from start) and move based on conditions.

- **When to use:** Sorted arrays, linked lists, or problems involving pairs/triplets
- **Problems:** Two Sum II, 3Sum, Container With Most Water

## 3. Fast & Slow Pointers (Floyd's Cycle Detection)

One pointer moves twice as fast as the other.

- **When to use:** Detect cycles, find midpoints, or duplicate numbers
- **Problems:** Linked List Cycle, Palindrome Linked List, Happy Number

## 4. Merge Intervals

Sort intervals, merge if overlapping.

- **When to use:** Scheduling, overlapping ranges
- **Problems:** Merge Intervals, Insert Interval, Meeting Rooms II

## 5. Cyclic Sort

Place each number at its correct index.

- **When to use:** Arrays with numbers in a fixed range (1 to N)
- **Problems:** Missing Number, Find All Duplicates in Array, First Missing Positive

## 6. Top K Elements (Heap / Priority Queue)

Use min-heap/max-heap for efficient tracking.

- **When to use:** Need top K largest/frequent elements
- **Problems:** Top K Frequent Elements, Kth Largest Element in Array, Sort Characters by Frequency

## 7. Prefix Sum

Precompute running sums, then answer queries in O(1).

- **When to use:** Range sums, subarrays, balancing problems
- **Problems:** Subarray Sum Equals K, Find Pivot Index, Range Sum Query

## 8. Bit Manipulation

Use AND, OR, XOR, shifts for optimization.

- **When to use:** Power of two checks, subsets, toggling bits
- **Problems:** Single Number, Counting Bits, Subsets using Bitmask

## 9. Binary Search

Divide search space using midpoints.

- **When to use:** Sorted arrays or monotonic search space
- **Problems:** Search in Rotated Sorted Array, Median of Two Sorted Arrays, Koko Eating Bananas

## 10. Binary Search on Answer

Search on feasible solution space.

- **When to use:** Optimize over a range of values (not necessarily sorted arrays)
- **Problems:** Capacity to Ship Packages, Minimum Number of Days to Make M Bouquets, Aggressive Cows

## 11. BFS (Breadth-First Search)

Use a queue to traverse level by level.

- **When to use:** Level-order traversal in trees/graphs, shortest path in unweighted graphs
- **Problems:** Binary Tree Level Order Traversal, Word Ladder, Rotten Oranges

## 12. DFS (Depth-First Search)

Go deep before backtracking.

- **When to use:** Explore all paths, recursive or iterative graph/tree traversal
- **Problems:** Number of Islands, Path Sum, Clone Graph

## 13. Backtracking

Try a choice → backtrack if invalid.

- **When to use:** Generate permutations, combinations, or subsets
- **Problems:** N-Queens, Sudoku Solver, Combination Sum

## 14. Greedy Algorithms

Build optimal solution step by step.

- **When to use:** Choose the best local option at each step
- **Problems:** Jump Game, Activity Selection, Gas Station

## 15. Union-Find (Disjoint Set Union)

Use parent & rank arrays for union and find operations.

- **When to use:** Cycle detection, connected components
- **Problems:** Number of Connected Components, Redundant Connection, Accounts Merge

## 16. Stack

Push elements until condition breaks, then pop.

- **When to use:** Balanced parentheses, next greater element
- **Problems:** Valid Parentheses, Daily Temperatures, Largest Rectangle in Histogram

## 17. Monotonic Stack

Maintain increasing or decreasing stack.

- **When to use:** Next greater/smaller problems, trapping water
- **Problems:** Next Greater Element II, Asteroid Collision, Trapping Rain Water

## 18. Trie (Prefix Tree)

Store characters in a tree-like structure.

- **When to use:** Prefix/suffix searching, autocomplete
- **Problems:** Implement Trie, Replace Words, Word Search II

## 19. Dynamic Programming (DP)

- **When to use:** Overlapping subproblems, optimization
- **Types:** 1D DP, 2D DP, DP on Subsets, DP on Strings

**Problems:**


| Type          | Problems                                |
| --------------- | ----------------------------------------- |
| 1D DP         | Climbing Stairs, House Robber           |
| 2D DP         | Edit Distance, Unique Paths             |
| DP on Subsets | Knapsack, Partition Equal Subset Sum    |
| DP on Strings | Longest Common Subsequence, Decode Ways |

## 20. Graph Algorithms

- **When to use:** Dependencies, shortest paths, traversals
- **Patterns:** Topological Sort, Shortest Path, Matrix Traversal

**Problems:**


| Pattern          | Problems                                    |
| ------------------ | --------------------------------------------- |
| Topological Sort | Course Schedule, Alien Dictionary           |
| Shortest Path    | Dijkstra, Bellman-Ford, BFS                 |
| Matrix Traversal | Word Search, Shortest Path in Binary Matrix |
