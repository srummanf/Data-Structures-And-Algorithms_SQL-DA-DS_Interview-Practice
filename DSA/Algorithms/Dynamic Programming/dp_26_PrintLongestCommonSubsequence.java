public class dp_26_PrintLongestCommonSubsequence {
    public static String longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        
        // Initialize the DP table
        int[][] dp = new int[m + 1][n + 1];
        
        // Fill the DP table using tabulation
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // Reconstruct the longest common subsequence
        int length = dp[m][n];
        char[] lcs = new char[length];
        int index = length - 1;
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                lcs[index--] = text1.charAt(i - 1);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        
        return new String(lcs);
    }
    
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println("Longest Common Subsequence: " + longestCommonSubsequence(text1, text2));
    }
}
