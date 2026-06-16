package Arrays;
// Microsoft Interview Experience Set 128 | (On-Campus for Internship)

// Given an array A of size m and another array B of size n. Return the product of maximum of A and minimum of B. (2 marks)
public class MaxMinProduct {
    public static int maxMinProduct(int[] A, int[] B) {
        int maxA = Integer.MIN_VALUE;
        int minB = Integer.MAX_VALUE;

        for (int num : A) {
            maxA = Math.max(maxA, num);
        }

        for (int num : B) {
            minB = Math.min(minB, num);
        }

        return maxA * minB;
    }

    public static void main(String[] args) {
        int[] A = {3, 7, 2, 8};
        int[] B = {4, 1, 9, 5};
        
        int result = maxMinProduct(A, B);
        System.out.println("The product of maximum of A and minimum of B is: " + result);
    }
}
