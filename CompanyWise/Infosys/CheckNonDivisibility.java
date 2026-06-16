/** You are given 3 integers K,L,R. FInd the total number of possible integers between L and R such that the integer is not divisible by any integers between 2 to K
java code */

import java.util.Scanner;

public class Main {

    // Check if num is divisible by any integer from 2 to K
    public static boolean isDivisible(int num, int K) {
        for (int i = 2; i <= K; i++) {
            if (num % i == 0) return true;
        }
        return false;
    }

    // Count non-divisible numbers in the range [L, R]
    public static int countNonDivisible(int K, int L, int R) {
        int count = 0;
        for (int i = L; i <= R; i++) {
            if (!isDivisible(i, K)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter K:");
        int K = scanner.nextInt();
        System.out.println("Enter L:");
        int L = scanner.nextInt();
        System.out.println("Enter R:");
        int R = scanner.nextInt();
        
        int result = countNonDivisible(K, L, R);
        System.out.println("Total number of integers between " + L + " and " + R + " that are not divisible by any integers between 2 to " + K + " is: " + result);
    }
}
