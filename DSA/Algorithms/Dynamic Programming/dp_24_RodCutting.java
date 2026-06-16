/**
 * Recurrence Relation
 * 
 * if ind == 0 return (W/wt[0])*val[0]
 * 
 * notTaken = 0 + RodCuttingUtil(ind-1, W);
 * if(wt[ind] <= W) taken = val[ind] + RodCuttingUtil(ind, W-wt[ind]);
 * 
 * return max(notTaken, taken);
 */


import java.util.Arrays;

class dp_24_RodCutting {

  static int RodCuttingUtil(int[] wt, int[] val, int ind, int W, int[][] dp) {
    if (ind == 0) {
      return ((int) (W / wt[0])) * val[0];
    }

    if (dp[ind][W] != -1) return dp[ind][W];

    int notTaken = 0 + RodCuttingUtil(wt, val, ind - 1, W, dp);

    int taken = Integer.MIN_VALUE;

    if (wt[ind] <= W) taken =
      val[ind] + RodCuttingUtil(wt, val, ind, W - wt[ind], dp);

    return dp[ind][W] = Math.max(notTaken, taken);
  }

  static int RodCutting(int n, int W, int[] val, int[] wt) {
    int[][] dp = new int[n][W + 1];

    for (int row[] : dp) Arrays.fill(row, -1);

    return RodCuttingUtil(wt, val, n - 1, W, dp);
  }

  public static void main(String args[]) {
    int wt[] = { 2, 4, 6 };
    int val[] = { 5, 11, 13 };
    int W = 10;

    int n = wt.length;

    System.out.println(
      "The Maximum value of items, the thief can steal is " +
      RodCutting(n, W, val, wt)
    );
  }
}
