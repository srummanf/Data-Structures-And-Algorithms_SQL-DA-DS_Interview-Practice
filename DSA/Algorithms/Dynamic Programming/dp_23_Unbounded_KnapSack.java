import java.util.Arrays;

public class dp_23_Unbounded_KnapSack {

  public static int recurrence(
    int idx,
    int w,
    int[] profit,
    int[] weight,
    int[][] dp
  ) {
    if (w == 0) {
      return 0; // If the remaining weight is 0, the maximum profit is 0
    }
    if (idx == 0) {
      return (w / weight[idx]) * profit[idx]; // Take as many items as possible for the last item
    }
    if (dp[idx][w] != -1) return dp[idx][w];
    int nottake = 0 + recurrence(idx - 1, w, profit, weight, dp);
    int take = Integer.MIN_VALUE;
    if (weight[idx] <= w) {
      take = profit[idx] + recurrence(idx, w - weight[idx], profit, weight, dp);
    }
    return dp[idx][w] = Math.max(take, nottake);
  }

  public static int unboundedKnapsack(
    int n,
    int w,
    int[] profit,
    int[] weight
  ) {
    // Write your code here.
    int[][] dp = new int[weight.length + 1][w + 1];
    for (int[] i : dp) {
      Arrays.fill(i, -1);
    }
    return recurrence(profit.length - 1, w, profit, weight, dp);
  }
}
