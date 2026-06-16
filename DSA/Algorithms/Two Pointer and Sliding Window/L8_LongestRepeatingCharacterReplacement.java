/** You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
  */

 class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        HashMap<Character, Integer> hm = new HashMap<>();
        int l = 0;
        int maxlen = 0;
        int maxfreq = 0;
        
        for (int r = 0; r < n; r++) {
            char rightChar = s.charAt(r);
            hm.put(rightChar, hm.getOrDefault(rightChar, 0) + 1);
            maxfreq = Math.max(maxfreq, hm.get(rightChar));

            // Calculate the current window size
            int windowSize = r - l + 1;

            // If the current window size minus the most frequent character's frequency is greater than k,
            // shrink the window from the left
            if (windowSize - maxfreq > k) {
                char leftChar = s.charAt(l);
                hm.put(leftChar, hm.get(leftChar) - 1);
                l++;
            }

            // Update the maximum length found so far
            maxlen = Math.max(maxlen, r - l + 1);
        }
        
        return maxlen;
    }
}
