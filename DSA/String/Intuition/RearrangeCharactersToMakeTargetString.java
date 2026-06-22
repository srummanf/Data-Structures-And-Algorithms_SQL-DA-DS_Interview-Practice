/* You are given two 0-indexed strings s and target. You can take some letters from s and rearrange them to form new strings.

Return the maximum number of copies of target that can be formed by taking letters from s and rearranging them.

 

Example 1:

Input: s = "ilovecodingonleetcode", target = "code"
Output: 2
Explanation:
For the first copy of "code", take the letters at indices 4, 5, 6, and 7.
For the second copy of "code", take the letters at indices 17, 18, 19, and 20.
The strings that are formed are "ecod" and "code" which can both be rearranged into "code".
We can make at most two copies of "code", so we return 2. */
        

public class RearrangeCharactersToMakeTargetString {
    public int rearrangeCharacters(String s, String target) {
    int ans = s.length();
    int[] countS = new int[128];
    int[] countT = new int[128];

    for ( char c : s.toCharArray())
      ++countS[c];

    for ( char c : target.toCharArray())
      ++countT[c];

    for ( char c : target.toCharArray())
      ans = Math.min(ans, countS[c] / countT[c]);

    return ans;
  }

    public static void main(String[] args) {
        RearrangeCharactersToMakeTargetString obj = new RearrangeCharactersToMakeTargetString();
        String s = "ilovecodingonleetcode";
        String target = "code";
        System.out.println(obj.rearrangeCharacters(s, target));
    }
}


/* class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int count = 0;

        while (true) {
            boolean possible = true;

            for (char ch : target.toCharArray()) {
                if (freq[ch - 'a'] == 0) {
                    possible = false;
                    break;
                }
                freq[ch - 'a']--;
            }

            if (!possible) {
                break;
            }

            count++;
        }

        return count;
    }
} */