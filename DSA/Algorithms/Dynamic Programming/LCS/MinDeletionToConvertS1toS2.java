/** Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

In one step, you can delete exactly one character in either string.

 

Example 1:

Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
Example 2:

Input: word1 = "leetcode", word2 = "etco"
Output: 4
  */

// Here we use LCS code -- We find the LCS and remove that by (n+m - 2*LCS)

class Solution {
    public int f(int i1, int i2, String s1, String s2, int[][] dp) {
        if (i1 < 0 || i2 < 0)
            return 0;
        if (dp[i1][i2] != -1)
            return dp[i1][i2];
        if (s1.charAt(i1) == s2.charAt(i2))
            return dp[i1][i2] = 1 + f(i1 - 1, i2 - 1, s1, s2, dp);
        else
            return dp[i1][i2] = Math.max(f(i1 - 1, i2, s1, s2, dp), f(i1, i2 - 1, s1, s2, dp));

    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        int dp[][] = new int[n][m];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        return n + m - 2*f(n-1, m-1, word1, word2, dp);
        
    }
}