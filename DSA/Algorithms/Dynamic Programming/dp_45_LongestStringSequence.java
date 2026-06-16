//Day 7

// Company Tags                : GOOGLE

import java.util.Arrays;

class Solution {

    private boolean isPredecessor(String prev, String curr) {
        int m = prev.length();
        int n = curr.length();

        if (n - m != 1 || m >= n)
            return false;

        int i = 0, j = 0;
        // prev should be a subsequence of curr
        while (i < m && j < n) {
            if (prev.charAt(i) == curr.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == m;
    }

    public int modifiedLIS(String[] words, int prevIdx, int currIdx, int[][] dp) {
        if (currIdx == words.length)
            return 0;

        if (prevIdx != -1 && dp[prevIdx][currIdx] != -1)
            return dp[prevIdx][currIdx];

        int take = 0;
        if (prevIdx == -1 || isPredecessor(words[prevIdx], words[currIdx])) {
            take = 1 + modifiedLIS(words, currIdx, currIdx + 1, dp);
        }
        int notTake = modifiedLIS(words, prevIdx, currIdx + 1, dp);

        if (prevIdx != -1)
            dp[prevIdx][currIdx] = Math.max(take, notTake);
        return Math.max(take, notTake);
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        int n = words.length;
        int[][] dp = new int[1000 + 1][1000 + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return modifiedLIS(words, -1, 0, dp);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = { "a", "ab", "ac", "bd", "abc", "abd", "abdd" };
        System.out.println(solution.longestStrChain(words)); // Expected Output: 4
    }
}





// https://leetcode.com/problems/longest-string-chain/description/

import java.util.Arrays;
import java.util.Comparator;

public class dp_45_LongestStringSequence {

  // Arranging the array based on ascending length of the string length
  public static String[] sortStringsByLength(String[] inputArray) {
    String[] sortedArray = Arrays.copyOf(inputArray, inputArray.length);
    Arrays.sort(sortedArray, Comparator.comparingInt(String::length));
    return sortedArray;
  }

  // Comparing two strings --> 2 pointer Appraoch
  boolean compare(String s1, String s2) {
    if (s1.length() != s2.length() + 1) return false;

    int first = 0;
    int second = 0;

    while (first < s1.length()) {
      if (second < s2.length() && (s1.charAt(first) == s2.charAt(second))) {
        first++;
        second++;
      } else first++;
    }
    if (
      first == s1.length() && second == s2.length()
    ) return true; else return false;
  }

  // Tabulation DP
  public int longestStrChain(String[] words) {
    int n = words.length;
    int maxi = 1;

    String[] arr = sortStringsByLength(words);

    int[] dp = new int[n];
    Arrays.fill(dp, 1);

    for (int i = 0; i <= n - 1; i++) {
      for (int prev_index = 0; prev_index <= i - 1; prev_index++) {
        if (compare(arr[i], arr[prev_index]) && (1 + dp[prev_index] > dp[i])) {
          dp[i] = 1 + dp[prev_index];
        }
      }

      if (dp[i] > maxi) maxi = dp[i];
    }
    return maxi;
  }
}
