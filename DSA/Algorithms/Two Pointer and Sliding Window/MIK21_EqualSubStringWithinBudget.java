/***
 * Problem Statement
Given two strings s and t of the same length and an integer maxCost, you want to find the maximum length of a substring that you can convert from s to t with a total cost less than or equal to maxCost. The cost of converting a character s[i] to t[i] is abs(s[i] - t[i]).
 */

public class MIK21_EqualSubStringWithinBudget {

  /**
   * This method finds the maximum length of a substring in s that can be converted to t
   * with a total cost less than or equal to maxCost.
   *
   * @param s The source string.
   * @param t The target string.
   * @param maxCost The maximum allowed cost to convert s to t.
   * @return The maximum length of the substring that can be converted within the given cost.
   */
  public int equalSubstring(String s, String t, int maxCost) {
    int i = 0, j = 0; // Two pointers for the sliding window
    int n = s.length(); // Length of the input strings
    int len = 0; // Variable to store the maximum length of the substring
    int currCost = 0; // Variable to store the current conversion cost

    // Iterate through the string using the pointer j
    while (j < n) {
      // Calculate the cost of converting s[j] to t[j] and add to current cost
      currCost += Math.abs(s.charAt(j) - t.charAt(j));

      // If the current cost exceeds maxCost, move the pointer i to reduce the window size
      while (currCost > maxCost) {
        currCost -= Math.abs(s.charAt(i) - t.charAt(i));
        i++;
      }

      // Update the maximum length of the valid window
      len = Math.max(len, j - i + 1);
      j++;
    }

    return len; // Return the maximum length of the valid substring
  }

  public static void main(String[] args) {
    MIK21_EqualSubStringWithinBudget eswb = new MIK21_EqualSubStringWithinBudget();
    String s = "abcd";
    String t = "bcdf";
    int maxCost = 3;
    System.out.println(eswb.equalSubstring(s, t, maxCost)); // Output: 3
  }
}
