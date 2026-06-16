/** Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal.

 

Example 1:

Input: s1 = "sea", s2 = "eat"
Output: 231
Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
Deleting "t" from "eat" adds 116 to the sum.
At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
Example 2:

Input: s1 = "delete", s2 = "leet"
Output: 403
Explanation: Deleting "dee" from "delete" to turn the string into "let",
adds 100[d] + 101[e] + 101[e] to the sum.
Deleting "e" from "leet" adds 101[e] to the sum.
At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
 

Constraints:

1 <= s1.length, s2.length <= 1000
s1 and s2 consist of lowercase English letters. */


import java.util.Arrays;

class Solution {
    // Recursive function with memoization to find minimum delete sum
    public int f(int i1, int i2, String s1, String s2, int[][] dp) {
        // Base cases
        if (i1 < 0 && i2 < 0) return 0; // Both strings are exhausted
        if (i1 < 0) return sumASCII(s2, i2); // s1 is exhausted, sum remaining ASCII values of s2
        if (i2 < 0) return sumASCII(s1, i1); // s2 is exhausted, sum remaining ASCII values of s1

        // If the value is already computed, return it
        if (dp[i1][i2] != -1)
            return dp[i1][i2];

        // If characters are the same, move both pointers
        if (s1.charAt(i1) == s2.charAt(i2))
            return dp[i1][i2] = f(i1 - 1, i2 - 1, s1, s2, dp);
        else
            return dp[i1][i2] = Math.min(
                (int) s1.charAt(i1) + f(i1 - 1, i2, s1, s2, dp), // Delete from s1
                (int) s2.charAt(i2) + f(i1, i2 - 1, s1, s2, dp)  // Delete from s2
            );
    }

    // Helper function to calculate the sum of ASCII values from 0 to end index
    private int sumASCII(String s, int end) {
        int sum = 0;
        for (int i = 0; i <= end; i++) {
            sum += (int) s.charAt(i);
        }
        return sum;
    }

    public int minimumDeleteSum(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n][m];
        
        // Initialize dp array with -1
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        return f(n - 1, m - 1, word1, word2, dp);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String word1 = "sea";
        String word2 = "eat";
        System.out.println("Minimum Delete Sum: " + sol.minimumDeleteSum(word1, word2));
    }
}
