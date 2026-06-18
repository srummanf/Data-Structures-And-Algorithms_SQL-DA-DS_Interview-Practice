/** Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

If multiple answers are possible, return any of them.

It is guaranteed that the length of the answer string is less than 104 for all the given inputs.

 

Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"
Example 2:

Input: numerator = 2, denominator = 1
Output: "2"
Example 3:

Input: numerator = 4, denominator = 333
Output: "0.(012)"
 

Constraints:

-231 <= numerator, denominator <= 231 - 1
denominator != 0 */


public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        
        StringBuilder sb = new StringBuilder();
        
        // Determine the sign
        if (numerator < 0 ^ denominator < 0)
            sb.append("-");
        
        // Convert to positive and handle as long to avoid overflow
        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);
        
        // Append the integer part
        sb.append(n / d);
        long remainder = n % d;
        
        if (remainder == 0) {
            return sb.toString();
        }
        
        sb.append(".");
        HashMap<Long, Integer> hm = new HashMap<>();
        
        while (remainder != 0) {
            if (hm.containsKey(remainder)) {
                sb.insert(hm.get(remainder), "(");
                sb.append(")");
                break;
            }
            
            hm.put(remainder, sb.length());
            remainder *= 10;
            sb.append(remainder / d);
            remainder %= d;
        }
        
        return sb.toString();
    }
}
