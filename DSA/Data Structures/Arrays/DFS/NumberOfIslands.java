class Solution {
    public void DFS(int[][] grid, int i, int j, boolean[][] vis) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || vis[i][j] || grid[i][j] == 0)
            return;
        vis[i][j] = true;
        DFS(grid, i + 1, j, vis);
        DFS(grid, i - 1, j, vis);
        DFS(grid, i, j + 1, vis);
        DFS(grid, i, j - 1, vis);
    }

    public int numberOfIslands(int[][] grid) {
        int ctr = 0;
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] vis = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    DFS(grid, i, j, vis);
                    ctr++;
                }
            }
        }

        return ctr;

    }

}