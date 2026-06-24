
class NumberOfZigZagArrayI {
    int MOD = 1_000_000_007;
    int N, M;

    int solve(int idx, int prevVal, boolean increasing) {

        if (idx == N) {
            return 1; // We reached till end of Zig Zag array and found one valid array
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

        return (int) result;
    }

    public int zigZagArrays(int n, int l, int r) {
        N = n;
        M = r - l + 1;
        long result = 0;

        // l = 1;
        // r = M;

        for (int startVal = 1; startVal <= M; startVal++) {
            // now index 0 has startVal(which is 1)

            // increasing
            result = (result + solve(1, startVal, true)) % MOD;

            // decreasing
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