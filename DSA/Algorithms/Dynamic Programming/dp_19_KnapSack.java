/**
 * KnapSack : Maximise profit based on constraints
 *  3  2  4
 * 30 40 60
 * 0  1  2
 * f(2,6) --> Till index 2 what is the max value you can get with weight 6
 *
 * nottake = 0 + f(ind-1, W)
 * take = intmin;
 * if(wt[ind] <= W) take = val[ind] + f(ind-1, W-wt[ind])
 * return max(take, nottake)
 */

/** You are given n items, each with a weight wt[i] and a value val[i], and a knapsack with a weight capacity W. Your goal is to determine the maximum value you can obtain by putting items into the knapsack such that the total weight of the selected items does not exceed W.

Input:

An integer array wt of size n where wt[i] represents the weight of the i-th item.
An integer array val of size n where val[i] represents the value of the i-th item.
An integer W representing the maximum weight capacity of the knapsack.
Output:

The maximum value that can be achieved within the given weight capacity W.
Examples:

Given wt = [1, 2, 3], val = [10, 15, 40], and W = 6, the maximum value that can be obtained is 55.
Given wt = [2, 3, 4, 5], val = [3, 4, 5, 6], and W = 5, the maximum value that can be obtained is 7.
Constraints:

1 <= n <= 100
0 <= wt[i], val[i] <= 1000
1 <= W <= 1000
The solution involves implementing three approaches:

A recursive approach.
A top-down dynamic programming approach with memoization.
A bottom-up dynamic programming approach.
The provided Java code includes implementations for all three approaches, demonstrating how to solve the knapsack problem using different techniques.

 */

// *** In DP , whenever you return SUM --> for Base Case : if Maximum is asked , return Integer.MIN and vice versa (Similar problem is seen in dp_20_MinCoins)
import java.util.Arrays;

public class dp_19_KnapSack {

  static int recursion(int ind, int W, int[] wt, int[] val) {
    if (ind == 0) {
      if (wt[ind] <= W) return val[ind]; else return Integer.MIN_VALUE;
    }
    int nottake = recursion(ind - 1, W, wt, val);
    int take = Integer.MIN_VALUE;
    if (wt[ind] <= W) {
      take = val[ind] + recursion(ind - 1, W - wt[ind], wt, val);
    }
    return Math.max(take, nottake);
  }

  static int DP_topdown(int ind, int W, int[] wt, int[] val, int[][] dp) {
    if (ind == 0) {
      if (wt[ind] <= W) {
        return val[ind];
      } else {
        return 0;
      }
    }
    if (dp[ind][W] != -1) return dp[ind][W];
    int nottake = DP_topdown(ind - 1, W, wt, val, dp);
    int take = Integer.MIN_VALUE;
    if (wt[ind] <= W) {
      take = val[ind] + DP_topdown(ind - 1, W - wt[ind], wt, val, dp);
    }
    return dp[ind][W] = Math.max(take, nottake);
  }

  static int bottomUpKnapsack(int W, int[] wt, int[] val, int n) {
    int[][] dp = new int[n + 1][W + 1];

    // Base case: If the weight capacity is 0, then the maximum profit is 0
    for (int i = 0; i <= n; i++) {
      dp[i][0] = 0;
    }

    // Base case: If there are no items, then the maximum profit is 0
    for (int j = 0; j <= W; j++) {
      dp[0][j] = 0;
    }

    // Fill the dp table in a bottom-up manner
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= W; j++) {
        int nottake = dp[i - 1][j]; // Not taking the current item
        int take = 0;

        if (wt[i - 1] <= j) { // If the weight of the current item is less than or equal to the remaining weight capacity
          take = val[i - 1] + dp[i - 1][j - wt[i - 1]]; // Taking the current item
        }

        dp[i][j] = Math.max(take, nottake); // Store the maximum value of take and nottake
      }
    }

    return dp[n][W]; // Return the maximum profit
  }

  public static void main(String[] args) {
    int[] wt = { 1, 2, 3 };
    int[] val = { 10, 15, 40 };
    int W = 6;
    int dp[][] = new int[wt.length + 1][W + 1];
    for (int i = 0; i <= wt.length; i++) {
      Arrays.fill(dp[i], -1);
    }
    System.out.println(recursion(wt.length - 1, W, wt, val));
    System.out.println(DP_topdown(wt.length - 1, W, wt, val, dp));
    System.out.println(bottomUpKnapsack(W, wt, val, wt.length));
  }
}
