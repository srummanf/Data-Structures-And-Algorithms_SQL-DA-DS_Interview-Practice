/** You are given an array of size N.

An array A is considered a summer array if all the even values in A are on one side and odd values are on the other side.

You are allowed to swap two adjacent elements in A in one operation. Find the minimum swap operations required to change A into a summer array.

Input Format

The first line contains an integer N, denoting the number of elements in A. Each line i of the N subsequent lines (where 0 <= i <= N) contains an integer describing A[i].

Constraints

1<= N <= 10^5

1 <= A[i] <= 10^5

Sample Input 1

3

1

2

2

Sample Output 1

0

Explanation:

Here N=3 A= [1,2,2]. 0 swaps are required here as the odd number is already on the left and all the even number are already on the right

 

Sample Input 2

3

1

2

1

Sample Output 2

1

Explanation:

Here N =3 A=[1,2,1]. We can swap 2 at 1st index with 1 at  0th index after which A becomes [2,1,1] satisfying the condition.

 
 */

import java.util.*;

class SummerArray {

    public static void main(String[] args) {
        
        int[] arr = {1,2,3,4,5,6};
        int n = arr.length;
        int evenCount = 0;
        int oddCount = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        int[] eo = new int[n]; // Expected odd on the left, even on the right
        int[] oe = new int[n]; // Expected even on the left, odd on the right
        
        // Create expected patterns
        for (int i = 0; i < evenCount; i++) eo[i] = 0; // even numbers on left
        for (int i = evenCount; i < n; i++) eo[i] = 1; // odd numbers on right
        
        for (int i = 0; i < oddCount; i++) oe[i] = 1; // odd numbers on left
        for (int i = oddCount; i < n; i++) oe[i] = 0; // even numbers on right

        // Calculate swaps needed for eo and oe
        int swapsEO = 0;
        int swapsOE = 0;
        
        int[] current = new int[n];
        for (int i = 0; i < n; i++) {
            current[i] = arr[i] % 2;
        }

        for (int i = 0; i < n; i++) {
            if (current[i] != eo[i]) {
                swapsEO++;
            }
            if (current[i] != oe[i]) {
                swapsOE++;
            }
        }

        // Minimum swaps required
        System.out.println(Math.min(swapsEO, swapsOE)/2);
    }
}

