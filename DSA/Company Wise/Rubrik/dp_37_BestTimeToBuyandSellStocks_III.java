// You can do k number of transaction ONLY - So like Knapsack
/**
 * Stock III - Only 2 transactions allowed
 * Stock IV - Only k transactions allowed
 */

import java.util.Arrays;

/**
 * Recurrence relation
 * f(ind, buy, cap){
 *  if(ind==n) return 0; // reached last day so no point in buying or selling
 *  if(cap==0) return 0; // no more transactions allowed
 * if(buy==1){
 *  profit = Max(-prices[ind] + f(ind+1, 0, cap), f(ind+1, 1, cap))
 * } else{
 *  profit = (Max(prices[ind] + f(ind+1, 1, cap-1), f(ind+1, 0, cap-1)
 * }
 *
 * return profit;
 * }
 */

public class dp_37_BestTimeToBuyandSellStocks_III {

  public static int maxProfit(int[] prices) {
    int n = prices.length;
    int cap = 2;
    // Creating a 3D dp array of size [n][2][cap+1]
    int[][][] dp = new int[n][2][cap + 1];

    // Initialize the dp array with -1
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 2; j++) {
        Arrays.fill(dp[i][j], -1);
      }
    }

    // Calculate and return the maximum profit
    return getAns_memoization(prices, n, 0, 0, 2, dp);
  }

  public static int getAns_memoization(
    int[] price,
    int n,
    int ind,
    int buy,
    int cap,
    int[][][] dp
  ) {
    // Base case: If we have processed all stocks or have no capital left, return 0 profit
    if (ind == n || cap == 0) return 0;

    // If the result for this state is already calculated, return it
    if (dp[ind][buy][cap] != -1) return dp[ind][buy][cap];

    int profit = 0;

    if (buy == 0) { // We can buy the stock
      profit =
        Math.max(
          0 + getAns_memoization(price, n, ind + 1, 0, cap, dp),
          -price[ind] + getAns_memoization(price, n, ind + 1, 1, cap, dp)
        );
    }

    if (buy == 1) { // We can sell the stock
      profit =
        Math.max(
          0 + getAns_memoization(price, n, ind + 1, 1, cap, dp),
          price[ind] + getAns_memoization(price, n, ind + 1, 0, cap - 1, dp)
        );
    }

    // Store the calculated profit in the dp array and return it
    return dp[ind][buy][cap] = profit;
  }

  static int maxProfit_tabulation(int[] prices) {
    int n = prices.length;

    // Creating a 3D dp array of size [n+1][2][3] initialized to 0
    int[][][] dp = new int[n + 1][2][3];

    // Loop through the dp array, starting from the second last stock (ind=n-1)
    for (int ind = n - 1; ind >= 0; ind--) {
      for (int buy = 0; buy <= 1; buy++) {
        for (int cap = 1; cap <= 2; cap++) {
          if (buy == 0) { // We can buy the stock
            dp[ind][buy][cap] =
              Math.max(
                0 + dp[ind + 1][0][cap],
                -prices[ind] + dp[ind + 1][1][cap]
              );
          }

          if (buy == 1) { // We can sell the stock
            dp[ind][buy][cap] =
              Math.max(
                0 + dp[ind + 1][1][cap],
                prices[ind] + dp[ind + 1][0][cap - 1]
              );
          }
        }
      }
    }

    // The maximum profit with 2 transactions is stored in dp[0][0][2]
    return dp[0][0][2];
  }

  public static void main(String[] args) {
    System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
  }
}
