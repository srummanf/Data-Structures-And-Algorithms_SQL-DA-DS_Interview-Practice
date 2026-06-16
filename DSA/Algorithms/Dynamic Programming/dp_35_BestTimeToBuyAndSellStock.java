/** You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0. */

public class dp_35_BestTimeToBuyAndSellStock {

  public int maxProfit(int[] prices) {
    int profit = 0;
    int minCostToBuy = prices[0];
    for (int i = 1; i < prices.length; i++) {
      int currProfit = prices[i] - minCostToBuy;
      minCostToBuy = Math.min(minCostToBuy, prices[i]);
      profit = Math.max(profit, currProfit);
    }
    return profit;
  }
}
