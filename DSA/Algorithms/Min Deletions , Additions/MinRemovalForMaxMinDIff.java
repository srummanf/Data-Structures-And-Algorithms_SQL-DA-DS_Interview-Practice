/** Problem statement
You have been given an array/list "ARR" consisting of 'N' integers. You have also given an integer 'K'.

Your task is to find the minimum number of elements that should be removed from "ARR" (possibly zero) such that the difference between the maximum element and the minimum element of the remaining "ARR" is less than or equal to 'K', i.e. ARRmax - ARRmin <= K.

Note :

1. "ARR" can contain duplicates.
For Example :

Input: 'N' = 4 , "ARR" =  [5, 10 , 2] and 'K' = 3.
Output: 1

Explanation : Currently, the difference between the maximum and minimum element in the array is 10 - 2 = 8, which is greater than K (3). 
So, we need to remove some elements. The optimal way to get our result is to remove 10. After removing 10, the difference between maximum and minimum is 5 - 2 = 3, which is less than or equal to K.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 100
1 <= N <= 5000
0 <= K <= 10^5
-10^5 <= ARR[i] <=10^5

Where 'N' denotes the number of elements in the given array/list, 'K' is the given integer and ARR[i] denotes the i-th element of the given array/list.

Time Limit : 1 second
Sample Input 1 :
1
3 1
2 -7 -11
Sample Output 1:
2
Explanation for Sample 1:
Currently, the difference between the maximum and minimum element in the array is 2 - (-11) = 13 which is greater than K (1). So, we need to remove some elements. The optimal way to get our result is to remove any 2 elements from the array because if we remove any one element, the difference between maximum and minimum will not become less than K (1). 

After removing any two elements the difference between maximum and minimum element becomes 0 which is less than or equal to K (1).
Sample Input 2 :
2
4 0
2 6 -5 2
4 4
1 2 5 3
Sample Output 2 :
2
0

 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int minRemovals(int[] arr, int K) {
        int N = arr.length;
        Arrays.sort(arr); // Sort the array
        
        int maxValidLength = 0;
        int start = 0;

        for (int end = 0; end < N; end++) {
            while (arr[end] - arr[start] > K) {
                start++;
            }
            maxValidLength = Math.max(maxValidLength, end - start + 1);
        }

        return N - maxValidLength; // Total elements minus the largest valid window
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] arr = new int[N];
            
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            
            System.out.println(minRemovals(arr, K));
        }
        
        sc.close();
    }
}
