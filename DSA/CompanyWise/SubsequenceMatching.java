/**
 * Problem statement
You are given three strings “A”, “B” and “C”. Your task is to check whether “C” is formed by an interleaving of A and B. C is said to be interleaving “A” and “B”, if the length of “C” is equal to the sum of the length of A and length of B, all the characters of “A” and “B” are present in “C”, and the order of all these characters remains the same in all three strings.

For Example:
If A = “aab”, B = “abc”, C = “aaabbc”
Here C is an interleaving string of A and B. Because C contains all the characters of A and B and the order of all these characters is also the same in all three strings.
 */

public class SubsequenceMatching {

  public static boolean isInterleave(String A, String B, String C) {
    if (A.length() + B.length() != C.length()) {
      return false;
    }

    boolean[][] dp = new boolean[A.length() + 1][B.length() + 1];
    for (int i = 0; i <= A.length(); i++) {
      for (int j = 0; j <= B.length(); j++) {
        if (i == 0 && j == 0) {
          dp[i][j] = true;
        } else if (i == 0) {
          dp[i][j] = dp[i][j - 1] && B.charAt(j - 1) == C.charAt(i + j - 1);
        } else if (j == 0) {
          dp[i][j] = dp[i - 1][j] && A.charAt(i - 1) == C.charAt(i + j - 1);
        } else {
          dp[i][j] =
            (dp[i - 1][j] && A.charAt(i - 1) == C.charAt(i + j - 1)) ||
            (dp[i][j - 1] && B.charAt(j - 1) == C.charAt(i + j - 1));
        }
      }
    }

    return dp[A.length()][B.length()];
  }

  public static void main(String[] args) {
    System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac")); // true
    System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc")); // false
  }
}
