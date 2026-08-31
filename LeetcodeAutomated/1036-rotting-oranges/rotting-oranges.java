class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // 1. Make BFS Queue
        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;
        int mins = 0;

        // 2. Add ALL rotten oranges to Queue
        //    Count fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // 3. BFS
        while (!q.isEmpty()) {

            // Number of nodes at current BFS level
            int size = q.size();

            // Process one complete level
            for (int k = 0; k < size; k++) {

                // 4. q.poll() --> node
                int[] node = q.poll();

                int i = node[0];
                int j = node[1];

                // 5. Check all 4 neighbours
                int[][] directions = {
                    {1, 0},
                    {-1, 0},
                    {0, 1},
                    {0, -1}
                };

                for (int[] dir : directions) {

                    int ni = i + dir[0];
                    int nj = j + dir[1];

                    // 6. If neighbour is fresh
                    if (ni >= 0 && nj >= 0 &&
                        ni < m && nj < n &&
                        grid[ni][nj] == 1) {

                        // Mark visited / rotten
                        grid[ni][nj] = 2;

                        // One less fresh orange
                        fresh--;

                        // Add neighbour to Queue
                        q.add(new int[]{ni, nj});
                    }
                }
            }

            // One BFS level = one minute
            mins++;
        }

        // If fresh oranges remain, impossible
        if (fresh > 0) {
            return -1;
        }

        return mins == 0 ? 0 : mins - 1;
    }
}