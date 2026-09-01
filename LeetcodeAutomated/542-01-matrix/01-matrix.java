import java.util.*;

class Solution {

    int[][] bfs(int[][] mat, int r, int c) {

        Queue<int[]> q = new LinkedList<>();

        int[][] ans = new int[r][c];

        // Initialize answer with -1
        for (int i = 0; i < r; i++) {
            Arrays.fill(ans[i], -1);
        }

        boolean[][] vis = new boolean[r][c];

        // ------------------------------------------------
        // Add ALL 0s as sources
        // ------------------------------------------------

        for (int i = 0; i < r; i++) {

            for (int j = 0; j < c; j++) {

                if (mat[i][j] == 0) {

                    q.add(new int[]{i, j, 0});

                    ans[i][j] = 0;
                    vis[i][j] = true;
                }
            }
        }


        int[] rd = {0, 1, 0, -1};
        int[] cd = {-1, 0, 1, 0};


        // ------------------------------------------------
        // BFS
        // ------------------------------------------------

        while (!q.isEmpty()) {

            int[] current = q.poll();

            int n_i = current[0];
            int n_j = current[1];
            int dist = current[2];

            for (int a = 0; a < 4; a++) {

                int nn_i = n_i + rd[a];
                int nn_j = n_j + cd[a];

                // Check boundary
                if (nn_i >= 0 && nn_i < r &&
                    nn_j >= 0 && nn_j < c) {

                    // If not visited
                    if (!vis[nn_i][nn_j]) {

                        vis[nn_i][nn_j] = true;

                        ans[nn_i][nn_j] = dist + 1;

                        q.add(new int[]{
                            nn_i,
                            nn_j,
                            dist + 1
                        });
                    }
                }
            }
        }

        return ans;
    }


    public int[][] updateMatrix(int[][] mat) {

        int r = mat.length;
        int c = mat[0].length;

        return bfs(mat, r, c);
    }
}