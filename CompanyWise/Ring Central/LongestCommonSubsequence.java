// DP:25 Longest Common Subsequence https://www.youtube.com/watch?v=NPZn9jBrX8U&t=10s

// if(i1<0 or i2<0)
// return 0;

// if(charAt(i1) == charAt(i2))
// return 1 + f(i1-1, i2-1)

// else
// return max(f(i1-1, i2), f(i1, i2-1))

import java.util.*;

public class LongestCommonSubsequence {

  // Recursive Solution
  int LCS_recursion(String s1, String s2, int i1, int i2) {
    if (i1 < 0 || i2 < 0) return 0;
    if (s1.charAt(i1) == s2.charAt(i2)) return (
      1 + LCS_recursion(s1, s2, i1 - 1, i2 - 1)
    ); else return Math.max(
      LCS_recursion(s1, s2, i1 - 1, i2),
      LCS_recursion(s1, s2, i1, i2 - 1)
    );
  }

  static String LCS(String s1, String s2, int i1, int i2) {
    if (i1 < 0 || i2 < 0) {
      return "";
    }

    if (s1.charAt(i1) == s2.charAt(i2)) {
      // If characters match, include them in the LCS
      return LCS(s1, s2, i1 - 1, i2 - 1) + s1.charAt(i1);
    } else {
      // Otherwise, choose the longer LCS between excluding one character from either string
      String lcs1 = LCS(s1, s2, i1 - 1, i2);
      String lcs2 = LCS(s1, s2, i1, i2 - 1);
      return (lcs1.length() > lcs2.length()) ? lcs1 : lcs2;
    }
  }

  // Memoization Solution
  int LCS_memoization(String s1, String s2, int i1, int i2, int[][] dp) {
    if (i1 < 0 || i2 < 0) return 0; else {
      if (dp[i1][i2] != -1) return dp[i1][i2]; else {
        if (s1.charAt(i1) == s2.charAt(i2)) return (
          dp[i1][i2] = 1 + LCS_memoization(s1, s2, i1 - 1, i2 - 1, dp)
        ); else return (
          dp[i1][i2] =
            Math.max(
              LCS_memoization(s1, s2, i1 - 1, i2, dp),
              LCS_memoization(s1, s2, i1, i2 - 1, dp)
            )
        );
      }
    }
  }

  // Tabulation Solution
  int LCS_tabulation(String s1, String s2, int i1, int i2, int[][] dp) {
    for (int i = 0; i <= i1; i++) {
      for (int j = 0; j <= i2; j++) {
        if (i == 0 || j == 0) dp[i][j] = 0; else {
          if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] =
            1 + dp[i - 1][j - 1]; else dp[i][j] =
            Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[i1][i2];
  }

  public static void main(String[] args) {
    LongestCommonSubsequence ob = new LongestCommonSubsequence();
    String s1 = "aggtab";
    String s2 = "gxtxayb";

    System.out.println(
      ob.LCS_recursion(s1, s2, s1.length() - 1, s2.length() - 1)
    );
    System.out.println(
      ob.LCS(s1, s2, s1.length() - 1, s2.length() - 1)
    );

    // int m = s1.length(); // Replace with your desired row size
    // int n = s2.length(); // Replace with your desired row sizecolumn size

    // int[][] matrix = new int[m][n];

    // // Fill the matrix with -1 using Arrays.fill
    // for (int i = 0; i < m; i++) {
    //   Arrays.fill(matrix[i], -1);
    // }

    // System.out.println(
    //   ob.LCS_memoization(s1, s2, s1.length() - 1, s2.length() - 1, matrix)
    // );
  }
}
