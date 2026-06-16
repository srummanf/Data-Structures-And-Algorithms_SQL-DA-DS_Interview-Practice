import java.util.*;

class Solution {

    // Directions for traversal: up, right, down, left
    private static final int[] DEL_ROW = {-1, 0, 1, 0};
    private static final int[] DEL_COL = {0, 1, 0, -1};

    public int regionsBySlashes(String[] grid) {
        int gridSize = grid.length;
        int[][] expandedGrid = new int[gridSize * 3][gridSize * 3];

        // Populate the expanded grid based on the original grid
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                int baseRow = i * 3;
                int baseCol = j * 3;
                // Mark diagonal cells based on slashes
                if (grid[i].charAt(j) == '\\') {
                    expandedGrid[baseRow][baseCol] = 1;
                    expandedGrid[baseRow + 1][baseCol + 1] = 1;
                    expandedGrid[baseRow + 2][baseCol + 2] = 1;
                } else if (grid[i].charAt(j) == '/') {
                    expandedGrid[baseRow][baseCol + 2] = 1;
                    expandedGrid[baseRow + 1][baseCol + 1] = 1;
                    expandedGrid[baseRow + 2][baseCol] = 1;
                }
            }
        }

        int regionCount = 0;
        // Count regions using DFS flood fill
        for (int i = 0; i < gridSize * 3; i++) {
            for (int j = 0; j < gridSize * 3; j++) {
                if (expandedGrid[i][j] == 0) {
                    dfs(i, j, expandedGrid, gridSize * 3);
                    regionCount++;
                }
            }
        }
        return regionCount;
    }

    // DFS flood fill algorithm
    private void dfs(int row, int col, int[][] expandedGrid, int n) {
        expandedGrid[row][col] = 1; // mark the current cell as visited

        // Explore all 4 possible directions
        for (int i = 0; i < 4; i++) {
            int newRow = row + DEL_ROW[i];
            int newCol = col + DEL_COL[i];
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && expandedGrid[newRow][newCol] == 0) {
                dfs(newRow, newCol, expandedGrid, n);
            }
        }
    }
}
