// Asked in OA
/** You are given an array of integers where each integer is formatted as XYZ. Each number consists of three components:

X: The base, which is the leading digits of the number.
Y: The power, which consists of Z digits.
Z: The number of digits in the power Y.
For example:

2131 can be broken down as:

X = 21 (the base)
Y = 3 (the power)
Z = 1 (indicating that the power has 1 digit)
Thus, 2131 represents 21^3.
2132 can be broken down as:

X = 2 (the base)
Y = 13 (the power)
Z = 2 (indicating that the power has 2 digits)
Thus, 2132 represents 2^13.
Your task is to calculate the sum of all the numbers represented by the integers in the array. If the format of any integer is not feasible (i.e., Z is not valid based on the number's length), consider its value as 0.

Input:

An array of integers representing numbers in the XYZ format.
Output:

Return the sum of all the calculated values.
Constraints:

All integers in the array are positive.
The value of Z is always a single digit.

 */
public class XYZCalculator {
    public static void main(String[] args) {
        int[] array = {2131, 2132}; // Example input array
        System.out.println(sumOfXYZ(array));
    }

    public static int sumOfXYZ(int[] array) {
        int sum = 0;

        for (int num : array) {
            // Convert the number to string to easily extract X, Y, Z
            String str = String.valueOf(num);

            // Extract Z (number of digits in power)
            int Z = Character.getNumericValue(str.charAt(str.length() - 1));

            // Ensure Z is a valid index
            if (Z >= str.length() - 1 || Z <= 0) {
                return 0; // Return 0 if Z is not feasible
            }

            // Extract Y (the power value)
            int Y = Integer.parseInt(str.substring(str.length() - Z - 1, str.length() - 1));

            // Extract X (the base value)
            int X = Integer.parseInt(str.substring(0, str.length() - Z - 1));

            // Calculate X^Y
            int value = (int) Math.pow(X, Y);
            sum += value;
        }

        return sum;
    }
}
