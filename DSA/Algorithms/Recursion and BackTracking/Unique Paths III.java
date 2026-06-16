/** You are given an m x n integer array grid where grid[i][j] could be:

1 representing the starting square. There is exactly one starting square.
2 representing the ending square. There is exactly one ending square.
0 representing empty squares we can walk over.
-1 representing obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

 

Example 1:


Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2) */

class Solution {
    int totalPaths = 0;
    int emptyCells = 1; // Including the start cell

    public void dfs(int i, int j, int[][] grid, int r, int c, int er, int ec, int count) {
        // Boundary and obstacle check
        if (i < 0 || i >= r || j < 0 || j >= c || grid[i][j] == -1) {
            return;
        }

        // If we reach the end cell and have visited all the empty cells
        if (i == er && j == ec) {
            if (count == emptyCells) {
                totalPaths++;
            }
            return;
        }

        // Mark the cell as visited
        grid[i][j] = -1;

        // Explore all 4 possible directions
        dfs(i + 1, j, grid, r, c, er, ec, count + 1);
        dfs(i - 1, j, grid, r, c, er, ec, count + 1);
        dfs(i, j + 1, grid, r, c, er, ec, count + 1);
        dfs(i, j - 1, grid, r, c, er, ec, count + 1);

        // Backtrack: unmark the cell
        grid[i][j] = 0;
    }

    public int uniquePathsIII(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int sr = -1, sc = -1;
        int er = -1, ec = -1;

        // Find start, end, and count the number of empty cells
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    sr = i;
                    sc = j;
                }
                if (grid[i][j] == 2) {
                    er = i;
                    ec = j;
                }
                if (grid[i][j] == 0) {
                    emptyCells++;
                }
            }
        }

        // Start DFS from the start cell
        dfs(sr, sc, grid, r, c, er, ec, 0);
        return totalPaths;
    }
}

