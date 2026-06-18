import java.util.Arrays;

/**
 * dp22_CoinChangeWithInfiniteSupply
 * f(idx, amt) means ways to make amt using coins[0..idx]
 */
public class dp22_CoinChangeWithInfiniteSupply {

  public int f(int idx, int amt, int[] coins, int[][] dp) {
    if (idx == 0) {
      if (amt % coins[idx] == 0) return 1;
      if (amt == coins[idx] || amt == 0) return 1;
      return 0;
    }
    if (dp[idx][amt] != -1) return dp[idx][amt];
    int nottake = f(idx - 1, amt, coins, dp);
    int take = 0;
    if (coins[idx] <= amt) {
      take = f(idx, amt - coins[idx], coins, dp);
    }
    return dp[idx][amt] = take + nottake;
  }

  public int f_tabulation(int amt, int[] coins, int[][] dp) {
    for (int i = 0; i <= amt; i++) {
      if (i % coins[0] == 0) dp[0][i] = 1; else dp[0][i] = 0;
    }
    for (int i = 1; i < coins.length; i++) {
      for (int j = 0; j <= amt; j++) {
        int nottake = dp[i - 1][j];
        int take = 0;
        if (coins[i] <= j) {
          take = dp[i][j - coins[i]];
        }
        dp[i][j] = take + nottake;
      }
    }
    return dp[coins.length - 1][amt];
  }

  public int change(int amount, int[] coins) {
    int[][] dp = new int[coins.length][amount + 1];
    for (int a[] : dp) Arrays.fill(a, -1);
    return f(coins.length - 1, amount, coins, dp);
  }

  public static void main(String[] args) {
    dp22_CoinChangeWithInfiniteSupply obj = new dp22_CoinChangeWithInfiniteSupply();
    int[] coins = { 1, 2, 3 };
    int amount = 4;
    System.out.println(obj.change(amount, coins));
    System.out.println(
      obj.f_tabulation(amount, coins, new int[coins.length][amount + 1])
    );
  }
}
