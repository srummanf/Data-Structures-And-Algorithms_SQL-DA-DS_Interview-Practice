/**
 * Given an integer array(0-based indexing) a of size n. Your task is to return the maximum value of the sum of i*a[i] for all 0<= i <=n-1, where a[i] is the element at index i in the array. The only operation allowed is to rotate(clockwise or counterclockwise) the array any number of times.

Example 1:

Input: n = 4, a[] = {8, 3, 1, 2}
Output: 29
Explanation: All the configurations possible by rotating the elements are:
3 1 2 8 here sum is 3*0+1*1+2*2+8*3 = 29
1 2 8 3 here sum is 1*0+2*1+8*2+3*3 = 27
2 8 3 1 here sum is 2*0+8*1+3*2+1*3 = 17
8 3 1 2 here sum is 8*0+3*1+1*2+2*3 = 11, so the maximum sum will be 29.
 */


public class ModifiedMaxSumInRotationalArray {

    long max_sum_GPT(int a[], int n) {
        long arraySum = 0;
        long S = 0;
        
        for (int i = 0; i < n; i++) {
            arraySum += a[i];
            S += i * a[i];
        }
        
        long maxSum = S;
        
        for (int i = 1; i < n; i++) {
            S = S + arraySum - n * a[n - i];
            maxSum = Math.max(maxSum, S);
        }
        
        return maxSum;
    }

  long rotateClockWise(int[] a) {
    int n = a.length;
    int temp = a[n - 1];
    long sum = a[n - 1] * 0;

    for (int i = n - 1; i >= 1; i--) {
      a[i] = a[i - 1];
      sum += (long) a[i] * i;
    }
    a[0] = temp;
    // System.out.println(Arrays.toString(a));
    return sum;
  }

  long max_sum(int a[], int n) {
    // Your code here
    long maxi = Long.MIN_VALUE;
    for (int i = 1; i <= n; i++) {
      // System.out.println(Arrays.toString(a));
      long temp = rotateClockWise(a);

      maxi = Math.max(maxi, temp);
    }
    return maxi;
  }
}
