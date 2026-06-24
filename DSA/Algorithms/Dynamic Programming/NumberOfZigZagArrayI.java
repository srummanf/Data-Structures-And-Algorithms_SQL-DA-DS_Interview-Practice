import java.util.Arrays;

class NumberOfZigZagArrayI {
    int MOD = 1_000_000_007;
    int N, M;

    int[][][] t = new int[2001][2001][2];

    int solve(int idx, int prevVal, boolean increasing) {

        if (idx == N) {
            return 1;
        }

        int dir = increasing ? 1 : 0;

        if (t[idx][prevVal][dir] != -1) {
            return t[idx][prevVal][dir];
        }

        long result = 0;

        if (increasing) {
            for (int nextVal = prevVal + 1; nextVal <= M; nextVal++) {
                result = (result + solve(idx + 1, nextVal, false)) % MOD;
            }
        } else {
            for (int nextVal = 1; nextVal < prevVal; nextVal++) {
                result = (result + solve(idx + 1, nextVal, true)) % MOD;
            }
        }

        return t[idx][prevVal][dir] = (int) result;
    }

    public int zigZagArrays(int n, int l, int r) {
        N = n;
        M = r - l + 1;

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                Arrays.fill(t[i][j], -1);
            }
        }

        long result = 0;

        for (int startVal = 1; startVal <= M; startVal++) {

            // First move increasing
            result = (result + solve(1, startVal, true)) % MOD;

            // First move decreasing
            result = (result + solve(1, startVal, false)) % MOD;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        NumberOfZigZagArrayI obj = new NumberOfZigZagArrayI();
        int n = 3;
        int l = 1;
        int r = 3;
        System.out.println(obj.zigZagArrays(n, l, r));
    }
}