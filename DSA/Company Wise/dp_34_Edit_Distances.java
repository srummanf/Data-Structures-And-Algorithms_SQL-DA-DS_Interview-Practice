class Solution {
    public static int f(int i, int j, String s, String t, int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == t.charAt(j)) return dp[i][j]  = 0 + f(i-1, j-1, s, t, dp);
        else return dp[i][j] = 1 + Math.min( f(i-1, j, s, t, dp)  , Math.min(f(i, j-1, s, t, dp) , f(i-1, j-1, s, t, dp)));
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m= word2.length();
        int[][] dp = new int[n][m];
        for(int[] i : dp) Arrays.fill(i, -1);
        return f(n-1, m-1, word1, word2, dp);
    }
}