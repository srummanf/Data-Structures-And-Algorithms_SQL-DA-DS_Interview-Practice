class Solution {
    public String rev(String s) {
        String ans = "";
        int n = s.length();
        for (int i = 0; i < n; i++) {
            ans = s.charAt(i) + ans;
        }
        return ans;
    }

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

    public int longestPalindromeSubseq(String s) {

        int n = s.length();
        int dp[][] = new int[n][n];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        String r = rev(s);
        return f(n - 1, n - 1, s, r, dp);

    }

        // Total Length - Palindromic Length
      public int minInsertions(String s) {
        return s.length() - longestPalindromeSubseq(s);
    }
}