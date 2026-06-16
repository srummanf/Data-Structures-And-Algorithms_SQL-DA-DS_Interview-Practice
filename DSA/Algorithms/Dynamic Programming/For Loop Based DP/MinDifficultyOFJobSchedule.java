/** You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the ith job, you have to finish all the jobs j where 0 <= j < i).

You have to finish at least one task every day. The difficulty of a job schedule is the sum of difficulties of each day of the d days. The difficulty of a day is the maximum difficulty of a job done on that day.

You are given an integer array jobDifficulty and an integer d. The difficulty of the ith job is jobDifficulty[i].

Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1 */
import java.util.Arrays;

class Solution {
    int[][] dp = new int[301][11];

    public int solve(int[] jd, int n, int idx, int d, int[][] dp) {
        if (d == 1) {
            int maxD = jd[idx];
            for (int i = idx; i < n; i++) {
                maxD = Math.max(maxD, jd[i]);
            }
            return maxD;
        }

        if (dp[idx][d] != -1) return dp[idx][d];

        int maxD = -1;
        int finalResult = Integer.MAX_VALUE;

        for (int i = idx; i <= n - d; i++) {
            maxD = Math.max(maxD, jd[i]);
            int result = maxD + solve(jd, n, i + 1, d - 1, dp);
            finalResult = Math.min(finalResult, result);
        }

        dp[idx][d] = finalResult;
        return dp[idx][d];
    }

    public int minDifficulty(int[] jd, int d) {
        for (int[] a : dp)
            Arrays.fill(a, -1);
        int n = jd.length;
        if (n < d)
            return -1;

        return solve(jd, n, 0, d, dp);
    }
}
