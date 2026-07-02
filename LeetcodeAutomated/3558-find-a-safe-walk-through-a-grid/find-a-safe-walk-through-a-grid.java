class Solution {

    public int minimumHealthLoss(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[0][0] = grid[0][0];
        pq.offer(new int[] { grid[0][0], 0, 0 });

        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int cost = curr[0];
            int row = curr[1];
            int col = curr[2];

            if (cost > dist[row][col])
                continue;

            if (row == n - 1 && col == m - 1)
                return cost;

            for (int i = 0; i < 4; i++) {
                int newr = row + dr[i];
                int newc = col + dc[i];

                if (newr >= 0 && newr < n && newc >= 0 && newc < m) {

                    int newCost = cost + grid[newr][newc];

                    if (newCost < dist[newr][newc]) {
                        dist[newr][newc] = newCost;
                        pq.offer(new int[] { newCost, newr, newc });
                    }
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int rows = grid.size();
        int cols = grid.get(0).size();

        int[][] arr = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = grid.get(i).get(j);
            }
        }

        int minHealthLoss = minimumHealthLoss(arr);

        return minHealthLoss < health;
    }
}