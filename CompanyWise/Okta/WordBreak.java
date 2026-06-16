/** Problem Statement


Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.


Note that the same word in the dictionary may be reused multiple times in the segmentation.


Example 1:

Input: s = "applepenapple", wordDict = ["apple","pen"]

Output: true

Explanation: Return true because "applepenapple" can be segmented as "apple pen apple". Note that you are allowed to reuse a dictionary word.


Example 2:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]

Output: false
Input format :

The first line of input consists of a string s, representing the input string.

The second line consists of an integer n, indicating the number of words in the dictionary.

The next line consists of n space-separated strings representing the words of the dictionary.
Output format :

If the input string can be segmented into words from the dictionary, output "true".

If the input string cannot be segmented into words from the dictionary, output "false".


Refer to the sample output for the formatting specifications.
Code constraints :

1 ≤ s.length ≤ 100

1 ≤ wordDict.length ≤ 10

1 ≤ wordDict[i].length ≤ 100

s and wordDict[i] consist of only lowercase English letters.

All the strings of wordDict are unique.
Sample test cases :
Input 1 :

applepenapple
2
apple pen

Output 1 :

true

Input 2 :

catsandog
5
cats dog sand and cat

Output 2 :

false
 */

// --------------------------------- Recursive Solution -----------------------------------
class Solution {

  public boolean solve(int idx, String s, List<String> wordDict) {
    if (idx == s.length()) return true;

    if (wordDict.contains(s)) return true;

    for (int i = idx + 1; i <= s.length(); i++) {
      if (
        wordDict.contains(s.substring(idx, i)) && solve(i, s, wordDict)
      ) return true;
    }

    return false;
  }

  public boolean wordBreak(String s, List<String> wordDict) {
    return solve(0, s, wordDict);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine().trim();
    int n = Integer.parseInt(sc.nextLine().trim());
    List<String> wordDict = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      String w = sc.next().trim();
      wordDict.add(w);
    }
    System.out.print(wordBreak(s, wordDict));
  }
}

// --------------------------------- DP - Memoization Solution -----------------------------------

class Solution {

  public boolean solve(
    int idx,
    String s,
    List<String> wordDict,
    Boolean[] memo
  ) {
    if (idx == s.length()) return true;
    if (memo[idx] != null) return memo[idx];

    for (int i = idx + 1; i <= s.length(); i++) {
      if (
        wordDict.contains(s.substring(idx, i)) && solve(i, s, wordDict, memo)
      ) {
        return memo[idx] = true;
      }
    }
    return memo[idx] = false;
  }

  public boolean wordBreak(String s, List<String> wordDict) {
    Boolean[] memo = new Boolean[s.length()];
    return solve(0, s, wordDict, memo);
  }
}
