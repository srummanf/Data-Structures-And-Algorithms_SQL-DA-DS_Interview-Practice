
import java.util.*;

class dp_1_fibonacci {

    int fib_memoization_topdown(int n, int dp[]) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = fib_memoization_topdown(n - 1, dp) + fib_memoization_topdown(n - 2, dp);
    }

    int fib_tabulation_bottomup(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    int fib_space_optimized(int n) {
        int prev2 = 0;
        int prev1 = 1;
        int curr = 0;
        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }

    public static void main(String[] args) {
        int n = 10;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        dp_1_fibonacci f = new dp_1_fibonacci();
        System.out.println(f.fib_memoization_topdown(n, dp));
        System.out.println(f.fib_tabulation_bottomup(n));
        System.out.println(f.fib_space_optimized(n));
    }
}
