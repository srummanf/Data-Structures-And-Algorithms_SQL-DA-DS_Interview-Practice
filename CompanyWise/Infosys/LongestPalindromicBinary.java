import java.util.*;

class LongestPalindromicBinary {

  // Check if the binary representation of an integer is a palindrome
  public static boolean isPalindromic(String s) {
    StringBuilder sb = new StringBuilder(s);
    sb.reverse();
    return s.equals(sb.toString());
  }

  public static void main(String[] args) {
    int N = 3; // Number of bits
    ArrayList<String> palindromicNumbers = new ArrayList<>();
    int maxLength = 0;

    // Iterate over all numbers from 0 to (2^N - 1)
    for (int i = 0; i < (1 << N); i++) {
      // Convert integer to binary string with leading zeros
      String binaryString = String
        .format("%" + N + "s", Integer.toBinaryString(i))
        .replace(' ', '0');

      // Check if the binary string is palindromic
      if (isPalindromic(binaryString)) {
        palindromicNumbers.add(binaryString);
        maxLength = Math.max(maxLength, binaryString.length());
      }
    }

    System.out.println(
      "Number of Palindromic Numbers = " + palindromicNumbers.size()
    );
    System.out.println(
      "Longest Palindromic Binary Number Length = " + maxLength
    );
    System.out.println("Palindromic Binary Numbers are:");
    for (String binary : palindromicNumbers) {
      System.out.println(binary);
    }
  }
}
