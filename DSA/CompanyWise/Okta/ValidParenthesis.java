/** Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.


An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.


Example 1

Input: s = "()"

Output: true


Example 2

Input: s = "()[]{}"

Output: true


Example 3

Input: s = "(]"

Output: false
Input format :

The input consists of a string s representing a sequence of parentheses, braces, and brackets '(), {}, []'.
Output format :

The output prints a single line containing either "true" if the sequence of parentheses, braces, and brackets in the input string s is valid, or "false" otherwise.


Refer to the sample output for formatting specifications.
Code constraints :

1 <= s.length <= 104

s consists of parentheses only '()[]{}'.
Sample test cases :
Input 1 :

()

Output 1 :

true

Input 2 :

()[]{}

Output 2 :

true

Input 3 :

(]

Output 3 :

false
 */

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(isValid("()"));       // Output: true
        System.out.println(isValid("()[]{}"));   // Output: true
        System.out.println(isValid("(]"));       // Output: false
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        
        return stack.isEmpty();
    }
}
