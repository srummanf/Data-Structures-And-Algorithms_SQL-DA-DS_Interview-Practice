/** DP 9. Unique Paths 2 | DP on Grid with Maze Obstacles : https://www.youtube.com/watch?v=TmhpgXScLyY&t=97s */

import java.util.Arrays;

class dp_9_MazeWithObstacle {

  public static int recursion(int i, int j, int maze[][]) {
    if (i >= 0 && j >= 0 && maze[i][j] == -1) return 0;
    if (i == 0 && j == 0) return 1;
    if (i < 0 || j < 0) return 0;
    int up = recursion(i - 1, j, maze);
    int down = recursion(i, j - 1, maze);
    return up + down;
  }

  public static int topdown(int i, int j, int dp[][], int maze[][]) {
    if (i >= 0 && j >= 0 && maze[i][j] == -1) return 0;
    if (i == 0 && j == 0) return dp[i][j] = 1;
    if (i < 0 || j < 0) return 0;
    if (dp[i][j] != -1) return dp[i][j];
    int up = topdown(i - 1, j, dp, maze);
    int down = topdown(i, j - 1, dp, maze);
    return dp[i][j] = up + down;
  }

  public static int bottomup(int i, int j, int maze[][]) {
    int dp[][] = new int[i + 1][j + 1];
    for (int k = 0; k <= i; k++) {
      for (int l = 0; l <= j; l++) {
        if (k >= 0 && l >= 0 && maze[k][l] == -1) {
          dp[k][l] = 0;
        } else if (k == 0 && l == 0) {
          dp[k][l] = 1;
        } else if (k == 0) {
          dp[k][l] = dp[k][l - 1];
        } else if (l == 0) {
          dp[k][l] = dp[k - 1][l];
        } else {
          dp[k][l] = dp[k - 1][l] + dp[k][l - 1];
        }
      }
    }
    return (dp[i][j]);
  }

  public static void main(String[] args) {
    int m = 3;
    int n = 3;
    int maze[][] = {
      {
        0,
        0,
        0
      },
      {
        0,
        -1,
        0
      },
      {
        0,
        0,
        0
      }
    };
    System.out.println(recursion(m - 1, n - 1, maze));
    int dp[][] = new int[m][n];
    for (int i = 0; i < m; i++) Arrays.fill(dp[i], -1);
    System.out.println(topdown(m - 1, n - 1, dp, maze));
    System.out.println(bottomup(m - 1, n - 1, maze));
  }
}
