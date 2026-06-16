/*
 * https://leetcode.com/problems/k-inverse-pairs-array/
 * https://www.youtube.com/watch?v=y9yo1kyW7Bg
 * The intuition is really diificult to understand. So revise it again and slight bad to write the code as well.
 * So revise it again.
 */

import java.util.Arrays;

public class KInversePair {

  final int MOD = (int) Math.pow(10, 9) + 7;

  public int kInversePairs(int n, int k) {
    int dp[][] = new int[n + 1][k + 1];
    for (int i = 0; i < n + 1; i++) {
      Arrays.fill(dp[i], -1);
    }
    return solve(n, k, dp);
  }

  int solve(int n, int k, int[][] dp) {
    if (n == 0) return 0;
    if (k == 0) return 1;
    if (dp[n][k] != -1) return dp[n][k];
    int result = 0;
    for (int i = 0; i <= Math.min(n - 1, k); i++) {
      result = (result % MOD + solve(n - 1, k - i, dp) % MOD) % MOD;
    }
    return dp[n][k] = result;
  }
}
