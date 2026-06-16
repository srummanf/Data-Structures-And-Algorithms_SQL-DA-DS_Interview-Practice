/** recursion 
 * 
 * class Solution {
    private static final int MOD = 1000000007;

    public int solve(int idx, int searchCost, int maxSoFar, int n, int m, int k) {
        if (idx == n) {
            return searchCost == k ? 1 : 0;
        }

        int result = 0;
        for (int i = 1; i <= m; i++) {
            if (i > maxSoFar) {
                result = (result + solve(idx + 1, searchCost + 1, i, n, m, k)) % MOD;
            } else {
                result = (result + solve(idx + 1, searchCost, maxSoFar, n, m, k)) % MOD;
            }
        }
        return result;
    }

    public int numOfArrays(int n, int m, int k) {
        return solve(0, 0, 0, n, m, k);
    }
}

 */

class Solution {
    private static final int MOD = 1000000007;

    public int solve(int idx, int searchCost, int maxSoFar, int n, int m, int k, int[][][] dp) {
        if (idx == n) {
            return searchCost == k ? 1 : 0;
        }

        if (dp[idx][searchCost][maxSoFar] != -1) {
            return dp[idx][searchCost][maxSoFar];
        }

        int result = 0;
        for (int i = 1; i <= m; i++) {
            if (i > maxSoFar) {
                result = (result + solve(idx + 1, searchCost + 1, i, n, m, k, dp)) % MOD;
            } else {
                result = (result + solve(idx + 1, searchCost, maxSoFar, n, m, k, dp)) % MOD;
            }
        }
        dp[idx][searchCost][maxSoFar] = result % MOD;
        return dp[idx][searchCost][maxSoFar];
    }

    public int numOfArrays(int n, int m, int k) {
        int[][][] dp = new int[50 + 1][50 + 1][100 + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < k + 1; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(0, 0, 0, n, m, k, dp);
    }
}
