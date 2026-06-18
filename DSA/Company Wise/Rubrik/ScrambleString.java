/** You are given an integer ‘N’ and two strings ‘S’ and 'R' each having size = ‘N’. You can scramble the string ‘S’ to obtain string 'R' using the following operations:

1. If the length of the string is greater than 1:

Select any random index and split the string into two non-empty substrings. For e.g: if the string is ‘S’, then divide it into two non-empty substrings ‘A’ and ‘B’ such that ‘S’ = ‘A’ + ‘B’.
You can choose to swap the two substrings or keep them in the same order, i.e., after this operation string ‘S’ may become either ‘S’ = ‘A’ + ‘B’ or ‘S’ = ‘B’ + ‘A’.
Apply the first step recursively on each of the two strings ‘A’ and ‘B’.
2. If the length of the string is equal to 1 then stop.

Your task is to return true if 'R' is a scrambled string of ‘S’ else return false.

Note:

1. Both the strings are non-empty and are of the same length.

2. You can apply the above operations any number of times on ‘S’.

3. The operations can only be applied on the string ‘S’.

4. ‘S’ and 'R' consist of lowercase letters only.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 50
1 <= len(S) <= 30

Where ‘len(S)’ represents the length of the string ‘S’.

Time Limit: 1 sec
Sample Input 1:
1
5
great rgeat 
Sample Output 1:
true
Explanation for Sample Input 1:
Note that the ‘/’ denotes the division of string.
One of the possible ways in which the operations can be applied on S is:
“great” -> “gr/eat” (Division at random index)
“gr/eat” -> “gr/eat” (Decided not to swap the two substrings and keep them in the same order.)
“gr/eat” -> “g/r / e/at” (Applying the same operation of division at random index recursively on both substrings).
“g/r / e/at” -> “r/g / e/at” (Random choice to swap the first substring and keeping the second substring same.)
“r/g / e/at” -> “r/g / e/ a/t” (Again applying the same algorithm recursively to divide at into a/t.)
“r/g / e/ a/t” -> “r/g / e/ a/t” (Random decision to keep the strings in same order and not swap them.)
Now since the length of all the strings is equal to 1, we stop the algorithm and the result of S = “rgeat” which is equal to T.
Hence return true.
Sample Input 2:
2
1
a a
5
pqrst  rptqs
Sample Output 2:
true
false
Explanation for Sample Input 2:
For the first test case, since both the strings are equal, we return true.

For the second test case, there is no possible sequence of operations to make S equal to T. For example, 
pqrst --> cut p|qrst
p|qrst → cut p, qr|st
p, qr|st --> scramble p, st, qr = pstqr which is scrambled and pq are apart. We cannot scramble rptqs into pqrst because there is no way in which we can cut pqrst such that prefix and suffix are anagrams of the correspondings in rptqs. See:

p | qrst --> 'p' not anagram of 'r' nor 's'
pq | rst --> pq not anagram of rp nor of qs
pqr | st --> pqr not anagram of rpt nor of tqs
pqrs | t --> pqrs not anagram of rptq nor of ptqs

Hence we return false. */

class Solution {

  private HashMap<String, Boolean> mp = new HashMap<>();

  public boolean solve_recursion(String s1, String s2) {
    if (s1.equals(s2)) return true;
    if (s1.length() != s2.length()) return false;
    int n = s1.length();
    boolean result = false;

    for (int i = 1; i < n; i++) {
      boolean swapped =
        solve(s1.substring(0, i), s2.substring(n - i, n)) &&
        solve(s1.substring(i, n), s2.substring(0, n - i));

      boolean not_swapped =
        solve(s1.substring(0, i), s2.substring(0, i)) &&
        solve(s1.substring(i, n), s2.substring(i, n));

      if (swapped || not_swapped) {
        result = true;
        break;
      }
    }

    return result;
  }

  public boolean solve(String s1, String s2) {
    // Base cases
    if (s1.equals(s2)) {
      return true;
    }
    if (s1.length() != s2.length()) {
      return false;
    }

    String key = s1 + "_" + s2;
    if (mp.containsKey(key)) {
      return mp.get(key);
    }

    boolean result = false;
    int n = s1.length();

    for (int i = 1; i < n; i++) {
      // Case 1: Swapped
      boolean swapped =
        solve(s1.substring(0, i), s2.substring(n - i, n)) &&
        solve(s1.substring(i, n), s2.substring(0, n - i));

      if (swapped) {
        result = true;
        break;
      }

      // Case 2: Not swapped
      boolean not_swapped =
        solve(s1.substring(0, i), s2.substring(0, i)) &&
        solve(s1.substring(i, n), s2.substring(i, n));

      if (not_swapped) {
        result = true;
        break;
      }
    }

    mp.put(key, result);
    return result;
  }

  public boolean isScramble(String s1, String s2) {
    // return solve_recursion(s1, s2);
    return solve(s1, s2);
  }
}
