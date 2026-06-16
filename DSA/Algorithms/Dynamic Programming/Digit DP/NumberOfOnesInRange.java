/** Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

 

Example 1:

Input: n = 13
Output: 6
Example 2:

Input: n = 0
Output: 0
 

Constraints:

0 <= n <= 10^9 */

class Solution {
    int[][][] dp = new int[10][2][10];

    public int solve(String s, int idx, int tight, int cnt) {
        if (idx == s.length())
            return cnt;
        if (dp[idx][tight][cnt] != -1)
            return dp[idx][tight][cnt];

        int limit = tight == 1 ? s.charAt(idx) - '0' : 9;
        int ans = 0;

        for (int i = 0; i <= limit; i++) {
            int updateCnt = cnt + (i == 1 ? 1 : 0);
            ans += solve(s, idx + 1, tight & (i == limit ? 1 : 0), updateCnt);
        }

        return dp[idx][tight][cnt] = ans;
    }

    public int countDigitOne(int n) {
        int l = 1;
        int r = n;
        String ri = Integer.toString(r);
        for (int[][] d1 : dp)
            for (int[] d2 : d1)
                Arrays.fill(d2, -1);

        int rightAns = solve(ri, 0, 1, 0);

        String li = Integer.toString(l - 1);
        for (int[][] d1 : dp)
            for (int[] d2 : d1)
                Arrays.fill(d2, -1);

        int leftAns = solve(li, 0, 1, 0);

        return (rightAns - leftAns);

    }
}

/**
 * Brute Force
 * class Solution {
 * public int countDigitOne(int n) {
 * int count = 0;
 * for (int i = 0; i <= n; i++) {
 * String s = Integer.toString(i);
 * for (char ch : s.toCharArray()) {
 * if (ch == '1')
 * count++;
 * }
 * }
 * return count;
 * 
 * }
 * }
 */