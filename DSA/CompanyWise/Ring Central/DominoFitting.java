// Asked in OA

/** You are given a box of dimensions 2 x 2 x N and you need to find the number of ways to fit 1 x 1 x 2 sized dominoes into the box. Write a function that calculates the number of ways to fit the dominoes using the given constraints. The result should be returned modulo 10^9+7
 */

import java.util.ArrayList;
import java.util.Scanner;

public class DominoFitting {

    static final long MOD = 1000000007;

    public static long find(int n) {
        if (n == 1) return 2;
        if (n == 2) return 9;

        ArrayList<Long> v = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            v.add(0L);
        }
        v.set(1, 2L);
        v.set(2, 9L);

        for (int i = 3; i <= n; i++) {
            long sign = (i % 2 == 0) ? 1 : -1; // Alternate between 1 and -1
            long val = (4 * v.get(i - 1) % MOD - v.get(i - 2) + 2 * sign + MOD) % MOD;
            v.set(i, val);
        }

        return v.get(n);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of N: ");
        int n = scanner.nextInt();

        System.out.println("The number of ways to fit the dominoes is: " + find(n));
        
        
    }
}
