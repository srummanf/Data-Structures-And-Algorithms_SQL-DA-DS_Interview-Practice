/**You are given a string s that consists of lower case English letters and brackets.

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets.

 

Example 1:

Input: s = "(abcd)"
Output: "dcba"
Example 2:

Input: s = "(u(love)i)"
Output: "iloveu"
Explanation: The substring "love" is reversed first, then the whole string is reversed.
Example 3:

Input: s = "(ed(et(oc))el)"
Output: "leetcode"
Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.
  */

import java.util.Stack;

class ReverseStringInParenthesis {
    public String reverse(String s) {
        int len = s.length();
        String ans = "";
        for (int i = len - 1; i >= 0; i--) {
            ans += s.charAt(i);
        }
        return ans;
    }

    public String reverseParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        char[] arr = s.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                st.push(i);
            } else if (arr[i] == ')') {
                int open = st.pop();
                reverse(arr, open + 1, i - 1);
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (char c : arr) {
            if (c != '(' && c != ')') {
                result.append(c);
            }
        }
        
        return result.toString();
    }
    
    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reverseParentheses("(abcd)")); // Output: "dcba"
        System.out.println(sol.reverseParentheses("(u(love)i)")); // Output: "iloveu"
        System.out.println(sol.reverseParentheses("(ed(et(oc))el)")); // Output: "leetcode"
    }
}
