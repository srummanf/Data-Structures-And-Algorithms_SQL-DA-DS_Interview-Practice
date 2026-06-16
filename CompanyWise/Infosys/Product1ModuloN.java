/** You are given an integer N.

You have to choose a set of integers S from the range [1, N-1] such that the product of integers in S is 1 modulo N. This means that if N=5, we can choose set S = [1,2,3] as the product is 6 and 6 modulo 5 is 1.

Find the length of the biggest set S you can choose.

Input Format

The first line contains an integer N, denoting the given integer.

Constraints

1<=N<= 5 * 10^5

Sample Input 1

7

Sample Output 1

5

Explanation:

We can choose set (1,2,3,4,5). Here product = 120 which mod 7 is 1

*/

import java.util.*;

class Product1ModuloN {

  public static int findLen(int n) {
    int len = 0;
    for (int i = 1; i <= n - 1; i++) {
      int mul = i;
      for (int j = i; j <= n - 1; j++) {
        mul *= j;
        if (mul % n == 1) {
          len = Math.max(len, (j - i + 1));
        }
      }
    }

    return len;
  }

  public static void main(String args[]) {
    int n = 7;
    System.out.println(findLen(n));
  }
}
