import java.math.BigInteger;

public class Learn {

  public static void main(String[] args) {
    // Creating BigInteger objects
    BigInteger num1 = new BigInteger("9876543210987654321");
    BigInteger num2 = new BigInteger("12345678901234567890");
    BigInteger num3 = new BigInteger("101010101010101", 2); // Binary representation

    // Arithmetic operations
    BigInteger sum = num1.add(num2);
    BigInteger difference = num2.subtract(num1);
    BigInteger product = num1.multiply(num2);
    BigInteger quotient = num2.divide(num1);
    BigInteger remainder = num2.remainder(num1);

    System.out.println("Sum: " + sum);
    System.out.println("Difference: " + difference);
    System.out.println("Product: " + product);
    System.out.println("Quotient: " + quotient);
    System.out.println("Remainder: " + remainder);

    // Bitwise operations
    BigInteger shiftLeft = num3.shiftLeft(2);
    BigInteger shiftRight = num3.shiftRight(2);
    BigInteger bitwiseAnd = num1.and(num2);
    BigInteger bitwiseOr = num1.or(num2);
    BigInteger bitwiseXor = num1.xor(num2);

    System.out.println("Shift Left: " + shiftLeft);
    System.out.println("Shift Right: " + shiftRight);
    System.out.println("Bitwise AND: " + bitwiseAnd);
    System.out.println("Bitwise OR: " + bitwiseOr);
    System.out.println("Bitwise XOR: " + bitwiseXor);

    // Comparison and equality
    System.out.println("num1 == num2? " + num1.equals(num2));
    System.out.println("num1 > num2? " + num1.compareTo(num2));
    System.out.println("num1 < num2? " + num2.compareTo(num1));

    // Conversion
    System.out.println("num1 in decimal: " + num1.toString());
    System.out.println("num3 in binary: " + num3.toString(2));

    // Checking for Even or Odd
    BigInteger number = new BigInteger("12");
    if (number.testBit(0) == false) {
      System.out.println("Even");
    } else {
      System.out.println("Odd");
    }
  }
}
