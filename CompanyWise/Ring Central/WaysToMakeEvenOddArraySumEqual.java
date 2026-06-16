/** Problem Statement

Leetcode 1664

Charlie is the Physical Education trainer in a school. ﻿The students of a class are standing in a line. The students can have the same or different weights. He wants to make the sum of the weights of alternative students equal to the sum of the weights of other alternative students. But he can’t achieve this in a simple way. 


First of all, he needs to figure out how many ways he can remove any student from the line and achieve his goal. 


Can you help Charlie find a number of possible ways?


Example


Input:

5

6 1 7 2 1

Output:

1

Explanation:

He can remove the second student from the line and now the order will be 6,7,2,1. And now he can easily achieve the goal. 6+2 = 7+1 = 8. So there is one possible way and the output is 1.
Input format :

The first line of input denotes the size of an array, N.

The next line contains N space-separated integer elements of the array.
Output format :

The output prints the number of possible ways Charlie can remove any student from the line to achieve his goal.
Code constraints :

1 < N < 10001

1 < array[i] < 100001
Sample test cases :
Input 1 :

5
6 1 7 2 1

Output 1 :

1

Input 2 :

5
2 2 2 2 2

Output 2 :

5 */


import java.util.*;

class Main {
    // Function to check if removing the student at index idx balances the sums
    public static boolean isPossible(List<Integer> arr, int idx) {
        int n = arr.size();
        int evenSum = 0, oddSum = 0;

        // Calculate sums without the element at index idx
        for (int i = 0; i < n; i++) {
            if (i == idx) continue; // Skip the removed element
            if ((i < idx && i % 2 == 0) || (i > idx && (i - 1) % 2 == 0)) {
                evenSum += arr.get(i);
            } else {
                oddSum += arr.get(i);
            }
        }

        return evenSum == oddSum;
    }

    // Function to count the number of ways to remove a student to balance the sums
    public static int count(List<Integer> arr) {
        int n = arr.size();
        int count = 0;

        // Check each element to see if removing it balances the sums
        for (int i = 0; i < n; i++) {
            if (isPossible(arr, i)) count++;
        }

        return count;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        System.out.println(count(arr));
    }
}
