import java.util.*;

class Solution {

    boolean BFS_CheckForCycle(
            int sr,
            int sc,
            char[][] grid,
            boolean[][] vis) {

        // {row, col, parentRow, parentCol}
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{sr, sc, -1, -1});
        vis[sr][sc] = true;

        int[] ROW_DIRECTIONS = {0, -1, 0, 1};
        int[] COL_DIRECTIONS = {1, 0, -1, 0};

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];

            int parentRow = current[2];
            int parentCol = current[3];

            // Check all 4 neighbours
            for (int i = 0; i < 4; i++) {

                int newRow = row + ROW_DIRECTIONS[i];
                int newCol = col + COL_DIRECTIONS[i];

                // Check boundary
                if (newRow >= 0 && newRow < grid.length &&
                    newCol >= 0 && newCol < grid[0].length) {

                    // Only same character can be part of cycle
                    if (grid[newRow][newCol] != grid[row][col]) {
                        continue;
                    }

                    // Unvisited cell
                    if (!vis[newRow][newCol]) {

                        vis[newRow][newCol] = true;

                        queue.add(new int[]{
                            newRow,
                            newCol,
                            row,
                            col
                        });
                    }

                    // Visited cell which is NOT parent
                    else if (newRow != parentRow ||
                             newCol != parentCol) {

                        return true;
                    }
                }
            }
        }

        return false;
    }


    public boolean containsCycle(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] vis = new boolean[rows][cols];

        // Multiple components
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (!vis[i][j]) {

                    if (BFS_CheckForCycle(i, j, grid, vis)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}