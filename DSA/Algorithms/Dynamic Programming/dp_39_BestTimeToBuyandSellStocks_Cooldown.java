/** Assumption Buy = 1, Sell = 0 */

class dp_39_BestTimeToBuyandSellStocks_Cooldown {
    public static int f_memoization(int ind, int buy, int[] prices, int[][] dp) {
        if (ind >= prices.length )
            return 0;

        if (dp[ind][buy] != -1)
            return dp[ind][buy];

        int profit = 0;
        if (buy == 1) {
            profit = Math.max(
                    -prices[ind] + f_memoization(ind + 1, 0, prices, dp),
                    0 + f_memoization(ind + 1, 1, prices, dp));
        } else {
            profit = Math.max(
                    prices[ind] + f_memoization(ind + 2, 1, prices, dp),
                    0 + f_memoization(ind + 1, 0, prices, dp));
        }
        return dp[ind][buy] = profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return f_memoization(0, 1, prices, dp);
    }
}