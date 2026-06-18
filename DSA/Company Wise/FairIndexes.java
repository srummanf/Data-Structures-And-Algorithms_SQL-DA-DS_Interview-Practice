/**
 * Problem statement
Levi Ackerman has two arrays, ‘A’ and ‘B’ consisting of ‘N’ integers each. He wants to divide these two arrays into two parts each, such that the sum of all the elements in the first part is equal to the sum of elements in the second part, and the index ‘k’ where the splitting is done, must be the same in both the arrays.

In simple terms, If he splits the array at index k, then (A[0]+A[1]....A[k]), (A[k + 1] + A[k + 2]....A[n - 1]), (B[0] + B[1]....B[k]), (B[k + 1] + B[k + 2]....B[n - 1]) are all equal.

Find the total number of all the Indexes which satisfy the given condition.

For Example :
n = 4, A = {2, 4, 5, 1}, B = {3, 3, 10, -4}

Now in this example, if we split the array at index 1 then the sum of all the subarrays is 2 + 4 = 6, 5 + 1 = 6, 3 + 3 = 6, 10 + (-4) = 6, and no other index satisfies this condition, hence the answer is 1.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= T <= 100
2 <= N <= 10^5
-10^9 <= A[i], B[i] <= 10^9

Time Limit: 1 second
Sample Input 1 :
2
3
1 2 3
2 1 3
2
6 6
10 2
Sample Output 1 :
1
0
Explanation For Sample Output 1 :
In the first test case, at index 1, the sum of the first array is 3, 3, and the sum of the second array is also 3, 3. Hence the answer is 1.

 In the second test case, There is no index satisfying the given condition. Hence, the answer is 0.
Sample Input 2 :
2
5
-5 2 -10 -3 6
-5 -10 3 4 -2
5  
1 4 2 -2 5 
7 -2 -2 2 5  
Sample Output 2 :
1
2 
 */


public class FairIndexes {
    public static int totalIndexes(int[] A, int[] B) {
        int count = 0;
        int sumA = 0, sumB = 0;
        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
            sumB += B[i];
        }
        int curA = 0;
        int curB = 0;
        for (int i = 0; i < A.length-1; i++) {
            curA += A[i];
            curB += B[i];
            if ((curA == curB) && ((sumA - curA) == (curB)))
                count++;
        }
        return count;
    }
}
