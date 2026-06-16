// DP 8. Grid Unique Paths | Learn Everything about DP on Grids | ALL TECHNIQUES : https://www.youtube.com/watch?v=sdE0A2Oxofw

/**
 1. Express everything in terms of i,j
 2. Do stuff
 3. Count/Max or Min
 4. Base Case
 */

// Recursive Solution
/**
 * if(i==0 && j==0) return 1;
 * if(i<0 || j<0) return 0;
 * up= f(i-1,j);
 * down= f(i,j-1);
 * return up+down;
 */

// Top Down - Memoization
//  dp[i][j] = up+down

// Bottom Up - Tabulation
/** dp[0][0] = 1
 * for(i=0;i<n;i++) {
 * for(j=0;j<m;j++) {
 * if(i==0 && j==0) dp[i][j] = 1;
 * if(i>0) up= dp[i-1][j];
 * if(j>0) down= dp[i][j-1];
 * dp[i][j] = up+down;
 */

// Bottom Up - Tabulation - Optimized
/** dp[n] = {0,0,0,..n}
 * temp[n] = ({compute})
 * dp[n] = temp[n]
 *
 * for(i=1;i<n;i++) {
 * for(j=1;j<m;j++) {
 * temp[j] = dp[j] + temp[j-1];
 * dp = temp;
 *
 */

class dp_8_Maze {

  public static int recursion(int i, int j) {
    if (i == 0 && j == 0) return 1;
    if (i < 0 || j < 0) return 0;
    int up = recursion(i - 1, j);
    int down = recursion(i, j - 1);
    return up + down;
  }

  public static int topdown(int i, int j, int dp[][]) {
    if (i == 0 && j == 0) return dp[i][j] = 1;
    if (i < 0 || j < 0) return 0;
    if (dp[i][j] != -1) return dp[i][j];
    int up = topdown(i - 1, j, dp);
    int down = topdown(i, j - 1, dp);
    return dp[i][j] = up + down;
  }

  public static int bottomup(int i, int j) {
    int dp[][] = new int[i + 1][j + 1];
    for (int k = 0; k <= i; k++) {
      for (int l = 0; l <= j; l++) {
        if (k == 0 && l == 0) {
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

  //CoPilot
  public static int bottomup_optimized(int i, int j) {
    int dp[] = new int[j + 1];
    dp[0] = 1;
    for (int k = 0; k <= i; k++) {
      for (int l = 1; l <= j; l++) {
        dp[l] = dp[l] + dp[l - 1];
      }
    }
    return (dp[j]);
  }

  public static void main(String[] args) {
    int m = 3;
    int n = 3;
    System.out.println(recursion(m - 1, n - 1));
    int dp[][] = new int[m + 1][n + 1];
    for (int i = 0; i < (m + 1); i++) {
      for (int j = 0; j < (n + 1); j++) {
        dp[i][j] = -1;
      }
    }
    System.out.println(topdown(m - 1, n - 1, dp));
    System.out.println(bottomup(m - 1, n - 1));
    System.out.println(bottomup_optimized(m - 1, n - 1));
  }
}
