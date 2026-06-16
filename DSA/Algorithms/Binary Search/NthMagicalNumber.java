/** A positive integer is magical if it is divisible by either a or b.

Given the three integers n, a, and b, return the nth magical number. Since the answer may be very large, return it modulo 109 + 7. */

class Solution {
    final static int mod = 1_000_000_007;

    // Corrected GCD function using long
    public long gcd(long a, long b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    // Corrected LCM function using long to prevent overflow
    public long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;  // Calculate LCM without overflow
    }

    // Function to calculate the number of values divisible by a or b up to n
    public long numberOfValuesDivisiblebyAorB(long n, long a, long b) {
        return n / a + n / b - n / lcm(a, b);
    }

    // Function to find the n-th magical number
    public int nthMagicalNumber(int n, int a, int b) {
        long mini = Math.min(a, b);
        long maxi = Math.max(a, b);
        long l = mini;
        long r = (long) n * maxi;  // Convert n * maxi to long
        
        // Binary search to find the n-th magical number
        while (l < r) {
            long mid = l + (r - l) / 2;
            if (numberOfValuesDivisiblebyAorB(mid, a, b) < n)
                l = mid + 1;
            else
                r = mid;
        }
        
        return (int) (l % mod);  // Return the result as int after applying mod
    }
}

// class Solution {
//     final static int mod = 1000000007;

//     public int gcd(int a, int b) {
//         if (b == 0)
//             return a;
//         else
//             return gcd(b, a % b);
//     }

//     public int lcm(int a, int b) {
//         // return (a * b) / gcd(a, b);
//         return (a / gcd(a, b)) * b;  // Avoid overflow
//     }

//     public int numberOfValuesDivisiblebyAorB(int n, int a, int b) {
//         return n / a + n / b - n / lcm(a, b);
//     }

//     public int nthMagicalNumber(int n, int a, int b) {
//         int mini = Math.min(a, b);
//         int maxi = Math.max(a, b);
//         int l = mini;
//         int r = n * maxi;
//         while (l < r) {
//             int mid = l + (r - l) / 2;
//             if (numberOfValuesDivisiblebyAorB(mid, a, b) < n)
//                 l = mid + 1;
//             else
//                 r = mid;

//         }
//         return l % mod;
//     }
// }

// class Solution {
// public int nthMagicalNumber(int n, int a, int b) {
// int ctr = 0;
// int num = 1;

// while (ctr < n) {
// if (num % a == 0 || num % b == 0) {
// ctr++;
// }
// if (ctr < n) {
// num++;
// }
// }

// return num;
// }
// }
