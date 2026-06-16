import java.util.*;

class Solution {
    private static final int MOD = 1000000007;

    public int numRollsToTarget(int n, int k, int target) {
        // dp[i][j] will store the number of ways to get sum j using i dice.
        // [no_of_dice][sum]
        int[][] dp = new int[n + 1][target + 1];
        
        // Base case: One way to get sum 0 with 0 dice.
        dp[0][0] = 1;

        // Iterate over each dice
        for (int i = 1; i <= n; i++) {
            // Iterate over each target sum from 1 to target
            for (int j = 1; j <= target; j++) {
                // Calculate the number of ways to reach sum j using i dice
                for (int x = 1; x <= k; x++) {
                    if (j - x >= 0) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - x]) % MOD;
                    }
                }
            }
        }
        
        return dp[n][target];
    }
}
