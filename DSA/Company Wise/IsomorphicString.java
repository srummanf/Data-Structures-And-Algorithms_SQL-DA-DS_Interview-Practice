/*** Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
 

Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character. */

class Solution {

  public boolean isIsomorphic(String s, String t) {
    HashMap<Character, Character> hm1 = new HashMap<>();
    HashMap<Character, Character> hm2 = new HashMap<>();

    int len = s.length();

    for (int i = 0; i < len; i++) {
      if (
        (hm1.containsKey(s.charAt(i)) && hm1.get(s.charAt(i)) != t.charAt(i)) ||
        (hm2.containsKey(t.charAt(i)) && hm2.get(t.charAt(i)) != s.charAt(i))
      ) return false; else {
        hm1.put(s.charAt(i), t.charAt(i));
        hm2.put(t.charAt(i), s.charAt(i));
      }
    }

    return true;
  }
}
