// class Solution {
//     public boolean isPrime(int n) {
//         int ctr = 0;
//         for (int i = 1; i <= n; i++) {
//             if (n % i == 0)
//                 ctr++;
//             if (ctr >= 3)
//                 return false;
//         }
//         return true;
//     }

//     public int countPrimes(int n) {
//         int ctr = 0;
//         for (int i = 2; i < n; i++) {
//             if (isPrime(i))
//                 ctr++;
//         }

//         return ctr;
//     }
// }

// Sieve of Eratosthenes
class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;

        // Step 1: Initialize a boolean array of size n
        boolean[] isPrime = new boolean[n];
        // Arrays.fill(isPrime, true); --> you can use this
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;  // Assume all numbers are prime initially
        }

        // Step 2: Start marking non-prime numbers
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // Mark all multiples of i as non-prime
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Step 3: Count the primes
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }
}
