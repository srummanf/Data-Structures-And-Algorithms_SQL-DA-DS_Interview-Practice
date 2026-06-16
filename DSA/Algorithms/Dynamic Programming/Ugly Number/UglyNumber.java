/** An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return true if n is an ugly number.

 

Example 1:

Input: n = 6
Output: true
Explanation: 6 = 2 × 3
Example 2:

Input: n = 1
Output: true
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5. */

class Solution {
    public boolean check(int n) {
        if(n==1) return true;
        if(n==0) return false;
        int d = n;
        while (d > 0) {
            if (d % 5 == 0) {
                d = d / 5;
            } else if (d % 3 == 0) {
                d = d / 3;
            } else if (d % 2 == 0) {
                d = d / 2;
            } else {
                return false;
            }
            if (d == 1)
                return true;
        }

        return false;

    }

    public boolean isUgly(int n) {
        return check(n);
    }
}