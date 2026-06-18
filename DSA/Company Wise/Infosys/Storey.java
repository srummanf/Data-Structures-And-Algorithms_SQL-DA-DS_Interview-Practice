/** We are constructing a building with N storeys. Each storey can have either 1,2,3 or 4 houses. Storeys with only 1 house are the most sought after and the most expensive 

Rich people who buy these expensive storeys prefer to live in quiet environments. They do not like having many neighbors and will tolerate at most 4 neighbors living in the storeys above and below them. If they are surrounded by 5 or more neighbors, they will be annoyed.

Find the number of ways to divide each storey into houses such that, after all the houses have been brought, no person is annoyed. Since the answer can be large, print it modulo 10^9+7

 */

public class Storey {
    private static final int MOD = (int) 1e9 + 7;

    public static int numWays(int n) {
        int[][] dp = new int[n + 1][5];

        // Base case: one storey with 1, 2, 3, or 4 houses
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[1][3] = 1;
        dp[1][4] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][1] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4]) % MOD;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]) % MOD;
            dp[i][3] = (dp[i - 1][1] + dp[i - 1][2]) % MOD;
            dp[i][4] = dp[i - 1][1] % MOD;
        }

        int result = 0;
        for (int j = 1; j <= 4; j++) {
            result = (result + dp[n][j]) % MOD;
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 3; // number of storeys
        System.out.println("Number of ways: " + numWays(n));
    }
}