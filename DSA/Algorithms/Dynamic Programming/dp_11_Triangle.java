
/**
 * DP 11. Triangle | DP on Triangle : https://www.youtube.com/watch?v=Y0ZqKpToTic
 * Problem Statement : Given a triangle, find the minimum path sum from top to bottom.
 * Sample Input 1:
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * Sample Output 1:
 * 11
 *
 * Explanation of sample input 1:
 * The triangle looks like:
 *   2
 *  3 4
 * 6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 11 (2 + 3 + 5 + 1 = 11).
 *
 * Companies asked: agoda
 * amazon
 * bloomberg
 * goldman-sachs
 * google
 * infosys
 * meta
 * microsoft
 * oracle
 * upstart
 * walmart-labs
 */

import java.util.Arrays;
import java.util.List;

public class dp_11_Triangle {

    int recursion(int[][] a, int i, int j) {
        int n = a.length;
        if (i == n - 1) {
            return a[i][j];
        }
        int d = a[i][j] + recursion(a, i + 1, j);
        int dg = a[i][j] + recursion(a, i + 1, j + 1);
        return Math.min(d, dg);
    }

    int topDownMemoization(int[][] a, int i, int j, int[][] dp) {
        int n = a.length;
        if (i == n - 1) {
            return dp[i][j] = a[i][j];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int d = a[i][j] + topDownMemoization(a, i + 1, j, dp);
        int dg = a[i][j] + topDownMemoization(a, i + 1, j + 1, dp);
        return dp[i][j] = Math.min(d, dg);
    }

    int bottomUpTabulation(int[][] a) {
        int n = a.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = a[n - 1][i];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = a[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }

    public int solve(List<List<Integer>> triangle, Integer[][] dp, int i, int j) {

        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int down = solve(triangle, dp, i + 1, j);
        int diagonal = solve(triangle, dp, i + 1, j + 1);

        return dp[i][j] = triangle.get(i).get(j) + Math.min(down, diagonal);
    }

    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();

        Integer[][] dp = new Integer[n][n];

        return solve(triangle, dp, 0, 0);
    }

    public static void main(String[] args) {
        dp_11_Triangle t = new dp_11_Triangle();
        int[][] a = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        int n = a.length;
        int dp[][] = new int[n][n];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(t.recursion(a, 0, 0));
        System.out.println(t.bottomUpTabulation(a));
        System.out.println(t.topDownMemoization(a, 0, 0, dp));

        List<List<Integer>> triangle = List.of(
                List.of(2),
                List.of(3, 4),
                List.of(6, 5, 7),
                List.of(4, 1, 8, 3)
        );
        System.out.println(t.minimumTotal(triangle));
    }

}
