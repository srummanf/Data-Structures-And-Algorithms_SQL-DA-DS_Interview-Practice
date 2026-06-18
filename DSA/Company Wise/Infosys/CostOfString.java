/** Cost of String :

You are given a string S which consists of lowercase Latin letters ('a','b','c',........,'z').

The cost of a string is defined as the sum of the absolute differences of ASCII values of all possible pairs of characters present in S.

• The pair with indices (i, j) and (j,i) is considered as a same pair.

Input Format
The first line contains a string, S, denoting the given string.

Constraint:
1<=len(s)<= 10^5 

*/

class CostOfString {

  public static int findCost_brute(String s) {
    int cost = 0;
    int n = s.length();
    for (int i = 0; i <= n - 1; i++) {
      for (int j = i + 1; j <= n - 1; j++) {
        int diff = Math.abs(s.charAt(i) - s.charAt(j));
        cost += diff;
      }
    }
    return cost;
  }

  public static int findCost(String s) {
    int n = s.length();
    int[] freq = new int[26];
    for (char ch : s.toCharArray()) {
      freq[ch - 'a']++;
    }

    int cost = 0;

    for (int i = 0; i <= n - 1; i++) {
      char ch = s.charAt(i);
      for (int j = 0; j <= 25; j++) {
        if (freq[j] > 0) {
          cost += Math.abs(ch - (char) (j + 'a')) * freq[j];
        }
      }
    }

    return cost ;
  }

  public static void main(String args[]) {
    String s = "rummmaaadddan";
    System.out.println("Optimsed - " + findCost(s));
    System.out.println("Brute - " + findCost_brute(s));
  }
}
