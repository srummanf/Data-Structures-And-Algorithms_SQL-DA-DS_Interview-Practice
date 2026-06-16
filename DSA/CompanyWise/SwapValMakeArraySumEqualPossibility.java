/**
 * Given two arrays of integers a[] and b[] of size n and m, the task is to check if a pair of values (one value from each array) exists such that swapping the elements of the pair will make the sum of two arrays equal.

Note: Return 1 if there exists any such pair otherwise return -1.

Example 1:

Input: n = 6, m = 4, a[] = {4, 1, 2, 1, 1, 2}, b[] = (3, 6, 3, 3)
Output: 1
Explanation: Sum of elements in a[] = 11, Sum of elements in b[] = 15, To get same sum from both arrays, we can swap following values: 1 from a[] and 3 from b[]
Example 2:

Input: n = 4, m = 4, a[] = {5, 7, 4, 6}, b[] = {1, 2, 3, 8}
Output: 1
Explanation: We can swap 6 from array a[] and 2 from array b[]

 */
import java.util.HashSet;

class SwapValMakeArraySumEqualPossibility {

  long findSwapValues(long a[], int n, long b[], int m) {
    // Your code goes here
    long suma = 0;
    long sumb = 0;
    HashSet<Long> hma = new HashSet<>();
    HashSet<Long> hmb = new HashSet<>();

    for (long i : a) {
      suma += i;
      hma.add(i);
    }
    for (long i : b) {
      sumb += i;
      hmb.add(i);
    }
    // Edge case 1: If the sum of both arrays is already equal, return 1
    if (suma == sumb) return (long) 1;

    long diff = (long) Math.abs(suma - sumb);
    // Edge case 2: If the difference between the sums is odd, return -1
    if (diff % 2 != 0) return (long) -1;
    
    for (int i = 0; i < Math.min(m, n); i++) {
      if (hmb.contains(diff - a[i])) {
        return (long) 1;
      }
    }
    return (long) -1;
  }
}
