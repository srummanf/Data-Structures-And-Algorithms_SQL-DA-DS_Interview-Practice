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

    // Total(m+n) - 2*LCS
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