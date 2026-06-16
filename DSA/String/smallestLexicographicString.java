// https://leetcode.com/problems/remove-duplicate-letters/
// Day 8
// Sol: https://www.youtube.com/watch?v=luCn7p2CIbI

import java.util.*;

class smallestLexicographicString {
    public String removeDuplicateLetters(String s) {

        Stack<Character> st = new Stack<>();
        int freq[] = new int[26];
        boolean exist[] = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']--;
            if (exist[ch - 'a'])
                continue;

            while (st.size() > 0 && st.peek() > ch && freq[st.peek() - 'a'] > 0) {
                char rem = st.pop();
                exist[rem - 'a'] = false;
            }

            st.push(ch);
            exist[ch - 'a'] = true;
        }

        char ans[] = new char[st.size()];
        int i = ans.length - 1;
        while (i >= 0) {
            ans[i--] = st.pop();
        }

        return new String(ans);

    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        smallestLexicographicString ob = new smallestLexicographicString();
        String s = scn.next();
        System.out.println(ob.removeDuplicateLetters(s));
    }
}
