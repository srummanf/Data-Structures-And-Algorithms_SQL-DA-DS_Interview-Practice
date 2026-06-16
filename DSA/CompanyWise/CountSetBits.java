// brian kernighan's algorithm
/**
 * while(n>0){
 *    ctr += n&1;
 *    n >>= 1;
 * }
 * ctr ---> counts the number of 1s in a binary representation of n
 */
import java.io.*;

class countSetBits {

  
  static int countSetBits(int n) {
    int count = 0;
    while (n > 0) {
      count += n & 1;
      n >>= 1;
    }
    return count;
  }

  public static void main(String args[]) {
    int i = 9;
    System.out.println(countSetBits(i));
  }
}

