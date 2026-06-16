/**
 * Given the binary representation of an integer as a string s, return the number of steps to reduce it to 1 under the following rules:

If the current number is even, you have to divide it by 2.

If the current number is odd, you have to add 1 to it.

It is guaranteed that you can always reach one for all test cases.
 */

import java.math.BigInteger;

class problem1 {

  /**
   * This method takes a binary string representation of an integer and returns
   * the number of steps required to reduce it to 1 following specific rules.
   *
   * @param s The binary string representation of an integer.
   * @return The number of steps to reduce the number to 1.
   */
  public int numSteps(String s) {
    int count = 0; // Initialize step counter
    BigInteger number = new BigInteger(s, 2); // Convert binary string to BigInteger

    // Loop until the number is reduced to 1
    while (!number.equals(BigInteger.ONE)) {
      if (number.testBit(0) == false) { // Check if the number is even
        number = number.shiftRight(1); // Divide by 2 using right shift
      } else {
        number = number.add(BigInteger.ONE); // Add 1 if the number is odd
      }
      count++; // Increment the step counter
    }

    return count; // Return the total number of steps
  }
}
