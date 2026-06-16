
/** Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

 

Example 1:


Input: n = 3
Output: 5
Example 2:

Input: n = 1
Output: 1
 */
// Catalan Numbers ==> Sum of f(i-1)*f(n-i)

class Solution {
    public int f(int[] dp, int n) {
        if (n <= 1)
            return 1;
        if (dp[n] != -1)
            return dp[n];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += f(dp, i - 1) * f(dp, n - i);
        }
        return ans;
    }

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return f(dp, n);

    }
}