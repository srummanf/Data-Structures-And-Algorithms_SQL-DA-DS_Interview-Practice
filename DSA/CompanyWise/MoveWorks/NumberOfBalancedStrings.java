/** Write a Java program with a function named numberOfBalancedStrings(int n, int d) that counts the number of ways we can make a balanced string of size n and difference d.

A Balanced string is a string where the difference between adjacent characters does not exceed d.

Input:
n = 3, d = 3

Output:
224

Input:
n = 2, d = 2

Output:
124 */

/** Problem Statement:
A Balanced String of length n is defined such that the absolute difference between ASCII positions of adjacent characters does not exceed d.

Return the number of distinct balanced strings of length n. Since the answer can be large, return it modulo 1e9+7.

Example 1:

Input: n = 3, d = 3  
Output: 224


Example 2:

Input: n = 2, d = 2  
Output: 124


Intuition:
Dynamic Programming can be used:

For each position i, try all characters a–z.

From dp[i-1][prev_char], transition to dp[i][curr_char] if |curr_char - prev_char| ≤ d.

Key Steps:

Initialize dp[0][j] = 1 for all letters.

For each position, compute transitions within d range.

Sum all ways at final position.

Apply modulo 1e9+7. */

import java.util.Arrays;

class NumberOfBalancedStrings {

  public static int numOfStrings(int n, int d) {
    if (n <= 0 || d < 0) return 0;

    int MOD = 1000000007;
    int[][] dp = new int[n][26];

    // Initialize the first character counts
    Arrays.fill(dp[0], 1);

    // Fill the dp array
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < 26; j++) {
        dp[i][j] = 0;
        for (int k = Math.max(0, j - d); k <= Math.min(25, j + d); k++) {
          dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
        }
      }
    }

    // Sum up all the ways to form a balanced string of length n
    int result = 0;
    for (int i = 0; i < 26; i++) {
      result = (result + dp[n - 1][i]) % MOD;
    }

    return result;
  }

  public static void main(String[] args) {
    int n = 2;
    int d = 2;
    System.out.println(numOfStrings(n, d)); // Output: Number of balanced strings
  }
}
