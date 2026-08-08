import java.util.*;
class dp_2_climbing_stairs {

    int recursive_solution(int n) {
        if (n <= 1) {
            return 1;
        }
        return recursive_solution(n - 1) + recursive_solution(n - 2);
    }

    int memoization_solution(int n, int[] memo) {
        if (n <= 1) {
            return 1;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        return memo[n] = memoization_solution(n - 1, memo) + memoization_solution(n - 2, memo);
    }

    int tabulation_solution(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    int space_optimized_solution(int n) {
        if (n <= 1) {
            return 1;
        }
        int prev2 = 1;
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
        dp_2_climbing_stairs cs = new dp_2_climbing_stairs();
        int n = 5;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        System.out.println(cs.recursive_solution(n));
        System.out.println(cs.memoization_solution(n, memo));
        System.out.println(cs.tabulation_solution(n));
        System.out.println(cs.space_optimized_solution(n)); 
    }
}
