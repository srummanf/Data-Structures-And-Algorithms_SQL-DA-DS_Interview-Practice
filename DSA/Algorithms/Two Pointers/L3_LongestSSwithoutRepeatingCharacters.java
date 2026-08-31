/** Given a string s, find the length of the longest substring without repeating characters. */

import java.util.HashMap;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int l = 0;
        int n = s.length();
        int maxi = 0;
        for(int r = 0; r<n; r++){
            char ch = s.charAt(r);
            if(hm.containsKey(ch)){
                l = Math.max(l, hm.get(ch)+1);
            }
            hm.put(ch, r);
            maxi = Math.max(maxi, r-l+1);
        }

        return maxi;

    }
}