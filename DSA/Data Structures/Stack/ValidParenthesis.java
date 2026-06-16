import java.util.Stack;

class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            // If the current character is an opening bracket, push it to the stack.
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                // If the stack is empty or the top of the stack doesn't match the current closing bracket, return false.
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                if (ch == ')' && top != '(') {
                    return false;
                } else if (ch == '}' && top != '{') {
                    return false;
                } else if (ch == ']' && top != '[') {
                    return false;
                }
            }
        }
        
        // If the stack is empty, all brackets were properly closed; otherwise, return false.
        return stack.isEmpty();
    }
}
