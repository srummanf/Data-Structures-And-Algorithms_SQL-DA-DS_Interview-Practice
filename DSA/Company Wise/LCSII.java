/** “You are given two strings, ‘s’ and ‘t,’ where ‘t’ is a subsequence of ‘s.’ Your task is to identify and remove the longest substring from ‘s’ such that ‘s’ still contains ‘t’ as a subsequence.”
 */

public class LCSII {

  public static void main(String[] args) {
    String s = "abpcplea";
    String t = "apple";
    System.out.println(removeLongestSubstring(s, t));
  }

  public static String removeLongestSubstring(String s, String t) {
    int maxLength = 0;
    String result = s;

    // Iterate over all possible substrings
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        String sub = s.substring(i, j + 1);
        String modified = s.substring(0, i) + s.substring(j + 1);

        if (isSubsequence(modified, t)) {
          if (sub.length() > maxLength) {
            maxLength = sub.length();
            result = modified;
          }
        }
      }
    }
    return result;
  }

  public static boolean isSubsequence(String s, String t) {
    int j = 0;
    for (int i = 0; i < s.length() && j < t.length(); i++) {
      if (s.charAt(i) == t.charAt(j)) {
        j++;
      }
    }
    return j == t.length();
  }


}
