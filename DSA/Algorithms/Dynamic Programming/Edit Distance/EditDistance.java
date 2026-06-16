/** Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
  */
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