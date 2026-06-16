/** Let's call some positive integer classy if its decimal representation contains no more than 3
 non-zero digits. For example, numbers 4
, 200000
, 10203
 are classy and numbers 4231
, 102306
, 7277420000
 are not.

You are given a segment [L;R]
. Count the number of classy integers x
 such that L≤x≤R
.

Each testcase contains several segments, for each of them you are required to solve the problem separately.

Input
The first line contains a single integer T
 (1≤T≤104
) — the number of segments in a testcase.

Each of the next T
 lines contains two integers Li
 and Ri
 (1≤Li≤Ri≤1018
).

Output
Print T
 lines — the i
-th line should contain the number of classy integers on a segment [Li;Ri]
.

Example
InputCopy
4
1 1000
1024 1024
65536 65536
999999 1000001
OutputCopy
1000
1
0
2 */

import java.util.Arrays;
import java.util.Scanner;

public class ClassyNumber {
    int[][][] dp = new int[19][2][19];

    public int solve(String s, int idx, int tight, int cnt) {
        if (idx == s.length()) {
            return 1;
        }
        if (dp[idx][tight][cnt] != -1) {
            return dp[idx][tight][cnt];
        }

        int limit = tight == 1 ? s.charAt(idx) - '0' : 9;
        int ans = 0;

        for (int i = 0; i <= limit; i++) {
            int updateCnt = cnt + (i != 0 ? 1 : 0);
            if (updateCnt <= 3) {
                ans += solve(s, idx + 1, tight & (i == limit ? 1 : 0), updateCnt);
            }
        }

        return dp[idx][tight][cnt] = ans;
    }

    public int countValidNumbers(int n) {
        String str = Integer.toString(n);
        for (int[][] d1 : dp)
            for (int[] d2 : d1)
                Arrays.fill(d2, -1);
        return solve(str, 0, 1, 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        ClassyNumber obj = new ClassyNumber();
        int result = obj.countValidNumbers(r) - obj.countValidNumbers(l - 1);
        System.out.println(result);
        sc.close();
    }
}
