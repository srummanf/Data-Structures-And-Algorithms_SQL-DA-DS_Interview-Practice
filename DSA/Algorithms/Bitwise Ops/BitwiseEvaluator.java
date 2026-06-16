// 128

// Given a string containing or ‘|’ , and ‘&’ and xor ‘^’ in between binary bits 1 or 0. Return the output.Evaluation is from left to right.

public class BitwiseEvaluator {
    public static int evaluateBitwiseExpression(String expression) {

        int result = 0;
        char operator = '|'; // Default operator to start with is OR

        for (char c : expression.toCharArray()) {
            if (c == '0' || c == '1') {
                int num = c - '0';
                if (operator == '|') {
                    result |= num;
                } else if (operator == '&') {
                    result &= num;
                } else if (operator == '^') {
                    result ^= num;
                }
            } else if (c == '|' || c == '&' || c == '^') {
                operator = c;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String inputExpression = "1^0|0&1";

        int output = evaluateBitwiseExpression(inputExpression);
        System.out.println("Output of the expression is: " + output);
    }
}
