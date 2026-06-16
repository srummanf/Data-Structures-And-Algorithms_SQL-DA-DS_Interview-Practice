/**
 * Recurrence relation
 * f(ind, buy){
 *  if(ind==n) return 0; // reached last day so no point in buying or selling
 * if(buy==1){
 *  profit = Max(-prices[ind] + f(ind+1, 0), f(ind+1, 1))
 * } else{
 *  profit = (Max(prices[ind] + f(ind+1, 1), f(ind+1, 0)
 * }
 * }
 */

public class dp_36_BestTimeToBuyandSellStocks {

  public static int maxProfit(int[] prices) {
    int n = prices.length;
    int[][] dp = new int[n][2];
    for (int i = 0; i < n; i++) {
      dp[i][0] = -1;
      dp[i][1] = -1;
    }
    return f_memoization(0, 1, prices, dp);
  }

  public static int f_memoization(int ind, int buy, int[] prices, int[][] dp) {
    if (ind == prices.length) return 0;
    if (dp[ind][buy] != -1) return dp[ind][buy];
    int profit = 0;
    if (buy == 1) {
      profit =
        Math.max(
          -prices[ind] + f_memoization(ind + 1, 0, prices, dp),
          0 + f_memoization(ind + 1, 1, prices, dp)
        );
    } else {
      profit =
        Math.max(
          prices[ind] + f_memoization(ind + 1, 1, prices, dp),
          0 + f_memoization(ind + 1, 0, prices, dp)
        );
    }
    return dp[ind][buy] = profit;
  }

  public static int f_tabulation(int[] val) {
    int n = val.length;
    int[][] dp = new int[n + 1][2];
    int profit = 0;
    // Write for Base Case
    for (int i = 0; i <= 1; i++) {
      dp[n][i] = 0;
    }

    // Copy the memoization and use loops
    // if(buy==1){
    // profit = Math.max((-val[idx] + f(idx+1, 0, val, dp)),(0 + f(idx+1, 1, val,
    // dp)) );
    // } else {
    // profit = Math.max((val[idx] + f(idx+1, 1, val, dp)),(0 + f(idx+1, 0, val,
    // dp)) );
    // }

    // return dp[idx][buy] = profit;

    for (int idx = n - 1; idx >= 0; idx--) {
      for (int buy = 0; buy <= 1; buy++) {
        if (buy == 1) {
          profit = Math.max((-val[idx] + dp[idx + 1][0]), (0 + dp[idx + 1][1]));
        } else {
          profit = Math.max((val[idx] + dp[idx + 1][1]), (0 + dp[idx + 1][0]));
        }
        dp[idx][buy] = profit;
      }
    }
    return dp[0][1];
  }

  public static void main(String[] args) {
    System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
  }
}
