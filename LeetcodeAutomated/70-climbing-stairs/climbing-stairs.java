class Solution {
     int memoization_solution(int n, int[] memo) {
        if (n <= 1) {
            return 1;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        return memo[n] = memoization_solution(n - 1, memo) + memoization_solution(n - 2, memo);
    }

    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return memoization_solution(n, memo);
    }
}