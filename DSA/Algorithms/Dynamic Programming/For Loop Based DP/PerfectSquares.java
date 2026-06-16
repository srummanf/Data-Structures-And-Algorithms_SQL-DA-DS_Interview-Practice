/** Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

 

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 

Constraints:

1 <= n <= 104 */


// class Solution {
//     public int f(int sum) {
//         if (sum == 0)
//             return 0;
//         int mini = Integer.MAX_VALUE;
//         for (int i = 1; i * i <= sum; i++) {
//             int result = 1 + f(sum - i * i);
//             mini = Math.min(mini, result);
//         }

//         return mini;
//     }

//     public int numSquares(int n) {
//         if(n==1) return 1;
//         return f(n);
//     }
// }

import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();

    public int f(int sum) {
        if (sum == 0) {
            return 0;
        }
        if (memo.containsKey(sum)) {
            return memo.get(sum);
        }

        int mini = Integer.MAX_VALUE;
        for (int i = 1; i * i <= sum; i++) {
            int result = 1 + f(sum - i * i);
            mini = Math.min(mini, result);
        }

        memo.put(sum, mini);
        return mini;
    }

    public int numSquares(int n) {
        return f(n);
    }
}
