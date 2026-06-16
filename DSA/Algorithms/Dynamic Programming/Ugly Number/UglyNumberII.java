/** An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return the nth ugly number. */

class Solution {
    public int nthUglyNumber(int n) {
        int[] arr = new int[n];  // To store ugly numbers
        arr[0] = 1;  // The first ugly number is 1
        
        int i2 = 0, i3 = 0, i5 = 0;  // Pointers for 2, 3, and 5 respectively
        int next2 = 2, next3 = 3, next5 = 5;  // Initial multiples of 2, 3, and 5
        
        for (int i = 1; i < n; i++) {
            // The next ugly number is the minimum of next2, next3, next5
            int nextUgly = Math.min(next2, Math.min(next3, next5));
            arr[i] = nextUgly;
            
            // Update the corresponding pointer when its multiple is chosen
            if (nextUgly == next2) {
                i2++;
                next2 = arr[i2] * 2;
            }
            if (nextUgly == next3) {
                i3++;
                next3 = arr[i3] * 3;
            }
            if (nextUgly == next5) {
                i5++;
                next5 = arr[i5] * 5;
            }
        }
        
        return arr[n - 1];  // Return the nth ugly number
    }
}
