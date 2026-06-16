import java.util.Scanner;

public class Probabilty_Jump {
    static double[] dp;
    static double P, Q;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        P = scanner.nextDouble();
        Q = 1 - P;
        dp = new double[N + 1];

        for (int i = 0; i <= N; i++) {
            dp[i] = -1.0;
        }

        double result = findProbability(N);
        System.out.printf("%.2f%n", result);
    }

    private static double findProbability(int N) {
        if (N == 0) return 1.0;
        if (N < 0) return 0.0;
        if (dp[N] != -1.0) return dp[N];

        dp[N] = P * findProbability(N - 2) + Q * findProbability(N - 3);
        return dp[N];
    }
}
