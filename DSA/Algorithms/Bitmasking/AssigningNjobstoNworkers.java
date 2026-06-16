import java.util.Scanner;

public class AssigningNjobstoNworkers {

    private static final int MAX_N = 21; // Based on the constraints in the C++ code
    private static int[][] cost = new int[MAX_N][MAX_N];

    //[job][mask];
    private static int[][] dp = new int[MAX_N][1 << MAX_N]; // 1<<x ==> 2powx or 2^x; //

    // Recursive function to solve the assignment problem
    
    private static int solve(int i, int mask, int n) {
        if (i == n) {
            return 0;
        }

        if (dp[i][mask] != -1) {
            return dp[i][mask];
        }

        int answer = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            if ((mask & (1 << j)) != 0) {
                answer = Math.min(answer, cost[j][i] + solve(i + 1, mask ^ (1 << j), n));
            }
        }

        return dp[i][mask] = answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = 1; // Number of test cases
        while (t-- > 0) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    cost[i][j] = scanner.nextInt();
                }
            }

            // Initialize dp array
            for (int[] row : dp) {
                java.util.Arrays.fill(row, -1);
            }

            System.out.println(solve(0, (1 << n) - 1, n));
        }

        scanner.close();
    }
}
