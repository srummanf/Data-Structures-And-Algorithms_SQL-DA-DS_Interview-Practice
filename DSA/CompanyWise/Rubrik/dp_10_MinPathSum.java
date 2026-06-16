// DP 10 : https://www.youtube.com/watch?v=_rgTlyky1uQ&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=11&t=4s

// Recursive Solution
/**
 * if(i==0 && j==0) return a[0][0];
 * if(i<0 || j<0) return 0;
 * up= a[i][j]+f(i-1,j);
 * down= a[i][j]+f(i,j-1);
 * return min(up,down);
 *
 * 1 3 1
 * 1 5 1
 * 4 2 1
 */

class dp_10_MinPathSum {

  public static int recursion(int i, int j, int[][] maze) {
    if (i == 0 && j == 0) return maze[i][j];
    if (i < 0 || j < 0) return 1000000; //Integer.MAX_VALUE not working
    int up = maze[i][j] + recursion(i - 1, j, maze);
    int left = maze[i][j] + recursion(i, j - 1, maze);
    return Math.min(left, up);
  }

  public static int topdown(int i, int j, int[][] maze, int[][] dp) {
    if (i == 0 && j == 0) return dp[i][j] = maze[i][j];
    if (i < 0 || j < 0) return 1000000;
    if (dp[i][j] != -1) return dp[i][j];
    int up = maze[i][j] + topdown(i - 1, j, maze, dp);
    int down = maze[i][j] + topdown(i, j - 1, maze, dp);
    return dp[i][j] = Math.min(up, down);
  }

  public static void main(String[] args) {
    int maze[][] = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
    int m = maze.length;
    int n = maze[0].length;
    int dp[][] = new int[m + 1][n + 1];
    for (int i = 0; i < (m + 1); i++) {
      for (int j = 0; j < (n + 1); j++) {
        dp[i][j] = -1;
      }
    }
    System.out.println(recursion(m - 1, n - 1, maze));
    System.out.println(topdown(m - 1, n - 1, maze, dp));
  }
}
