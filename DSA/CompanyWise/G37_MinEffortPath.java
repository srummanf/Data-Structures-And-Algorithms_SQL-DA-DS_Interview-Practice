class Solution {
    public int minimumEffortPath(int[][] heights) {
        // Create a priority queue containing arrays of cells
        // and their respective distance from the source cell in the
        // form {diff, row of cell, col of cell}.
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x, y) -> x[0] - y[0]);

        int n = heights.length;
        int m = heights[0].length;

        // Create a distance matrix with initially all the cells marked as
        // unvisited and the dist for source cell (0,0) as 0.
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = (int) (1e9);
            }
        }

        dist[0][0] = 0;
        pq.add(new int[] { 0, 0, 0 });

        // The following delta rows and delta columns array are created such that
        // each index represents each adjacent node that a cell may have
        // in a direction.
        int dr[] = { -1, 0, 1, 0 };
        int dc[] = { 0, 1, 0, -1 };

        // Iterate through the matrix by popping the elements out of the queue
        // and pushing whenever a shorter distance to a cell is found.
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int diff = current[0];
            int row = current[1];
            int col = current[2];

            // Check if we have reached the destination cell,
            // return the current value of difference (which will be min).
            if (row == n - 1 && col == m - 1)
                return diff;

            for (int i = 0; i < 4; i++) {
                int newr = row + dr[i];
                int newc = col + dc[i];

                // Checking validity of the cell.
                if (newr >= 0 && newc >= 0 && newr < n && newc < m) {

                    // Effort can be calculated as the max value of differences
                    // between the heights of the node and its adjacent nodes.
                    int newEffort = Math.max(Math.abs(heights[row][col] - heights[newr][newc]), diff);

                    // If the calculated effort is less than the previous value
                    // we update as we need the minimum effort.
                    if (newEffort < dist[newr][newc]) {
                        dist[newr][newc] = newEffort;
                        pq.add(new int[] { newEffort, newr, newc });
                    }
                }
            }
        }
        // If the destination is unreachable.
        return 0;
    }
}
