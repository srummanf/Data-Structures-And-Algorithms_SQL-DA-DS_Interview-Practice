class Solution {
    // public boolean isPrime(int n) {
    // int ctr = 0;
    // for (int i = 1; i <= n; i++) {
    // if (n % i == 0)
    // ctr++;
    // if (ctr >= 3)
    // return false;
    // }
    // return true;
    // }

    public boolean isPrime(int n) {
        if (n <= 1)
            return false; // 0 and 1 are not primes
        if (n == 2)
            return true; // 2 is the smallest prime number
        if (n % 2 == 0)
            return false; // Even numbers greater than 2 are not prime

        for (int i = 3; i * i <= n; i += 2) { // Check only odd numbers up to sqrt(n)
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int diagonalPrime(int[][] nums) {
        int rows = nums.length;
        int cols = nums[0].length;
        int maxi = 0;
        for (int i = 0; i < rows; i++) {
            int a = isPrime(nums[i][i]) ? nums[i][i] : Integer.MIN_VALUE;
            int b = isPrime(nums[i][nums.length - i - 1]) ? nums[i][nums.length - i - 1] : Integer.MIN_VALUE;
            maxi = Math.max(maxi, Math.max(a, b));
        }

        return maxi;

    }
}