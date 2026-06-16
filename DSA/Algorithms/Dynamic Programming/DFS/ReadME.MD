DFS-based Dynamic Programming (DP) problems typically involve using depth-first search (DFS) to explore possible states or paths and leveraging dynamic programming to store intermediate results (memoization) to avoid redundant calculations. These problems are often encountered in scenarios where we need to explore multiple combinations, subsets, or paths, and where optimal substructure and overlapping subproblems are present.

### Common Characteristics of DFS-based DP Problems:

- **State Exploration:** DFS is used to explore all possible states or paths from a given starting point.
- **Memoization:** Intermediate results are stored in a table or map to avoid recalculating the same state.
- **Recursive Structure:** Problems often have a natural recursive structure where the solution to a problem depends on the solutions to its subproblems.

### Suggested 10 LeetCode Problems:

1. **[Word Break](https://leetcode.com/problems/word-break/) (LeetCode #139)**

   - **Description:** Given a string and a dictionary of words, determine if the string can be segmented into a space-separated sequence of dictionary words.
   - **Difficulty:** Medium
2. **[Unique Paths III](https://leetcode.com/problems/unique-paths-iii/) (LeetCode #980)**

   - **Description:** Given a grid with obstacles, find all unique paths from the start to the finish, visiting all non-obstacle squares exactly once.
   - **Difficulty:** Hard
3. **[Longest Increasing Path in a Matrix](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/) (LeetCode #329)**

   - **Description:** Find the longest increasing path in a matrix where each step must move to an adjacent cell with a higher value.
   - **Difficulty:** Hard
4. **[Word Break II](https://leetcode.com/problems/word-break-ii/) (LeetCode #140)**

   - **Description:** Given a string and a dictionary of words, return all possible sentences that can be formed by breaking the string into words from the dictionary.
   - **Difficulty:** Hard
5. **[Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/) (LeetCode #131)**

   - **Description:** Partition a string into all possible palindromic substrings.
   - **Difficulty:** Medium
6. **[Concatenated Words](https://leetcode.com/problems/concatenated-words/) (LeetCode #472)**

   - **Description:** Given a list of words, find all words that are formed by concatenating two or more words from the list.
   - **Difficulty:** Hard
7. **[Minimum Cost to Merge Stones](https://leetcode.com/problems/minimum-cost-to-merge-stones/) (LeetCode #1000)**

   - **Description:** Find the minimum cost to merge all stones into one pile, following a specific merging rule.
   - **Difficulty:** Hard
8. **[Scramble String](https://leetcode.com/problems/scramble-string/) (LeetCode #87)**

   - **Description:** Determine if a string is a scramble of another string using recursive substring swaps.
   - **Difficulty:** Hard
9. **[Interleaving String](https://leetcode.com/problems/interleaving-string/) (LeetCode #97)**

   - **Description:** Determine if a string is an interleaving of two other strings.
   - **Difficulty:** Hard
10. **[Number of Ways to Paint N × 3 Grid](https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid/) (LeetCode #1411)**

    - **Description:** Find the number of ways to paint a grid such that no adjacent cells have the same color.
    - **Difficulty:** Hard

### Tips for Solving DFS-based DP Problems:

- **Identify Subproblems:** Break down the problem into smaller subproblems that can be solved independently.
- **Memoize Results:** Use a map or array to store the results of subproblems to avoid redundant calculations.
- **Base Cases:** Clearly define base cases to prevent infinite recursion.
- **Think Recursively:** Formulate the problem in a recursive manner, where the solution to the current state depends on solutions to smaller states.

These problems should provide a good mix of challenges to help you practice and master DFS-based DP techniques.
