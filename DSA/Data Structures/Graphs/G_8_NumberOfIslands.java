/** Problem: Number of Islands
 * Statement: Given a 2D grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * Example 1:
 * Input: grid = [["1","1","1","1","0"],
 *                ["1","1","0","1","0"],
 *                ["1","1","0","0","0"],
 *                ["0","0","0","0","0"]]
 * Output: 1
 */

class G_8_NumberOfIslands {
    void dfs(char[][] grid, boolean[][] vis, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0' || vis[i][j])
            return;

        vis[i][j] = true;

        dfs(grid, vis, i + 1, j);
        dfs(grid, vis, i - 1, j);
        dfs(grid, vis, i, j + 1);
        dfs(grid, vis, i, j - 1);
    }

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) return 0;

        
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] vis = new boolean[rows][cols];

        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    count++;
                    dfs(grid, vis, i, j);
                }
            }
        }

        return count;
    }
}