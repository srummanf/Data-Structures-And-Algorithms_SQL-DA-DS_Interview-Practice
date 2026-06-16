// Microsoft Interview Experience Set 128 | (On-Campus for Internship)

// Java implementation to find the number closest to n
// and divisible by m
public class close_to_n_divisible_m {

    // function to find the number closest to n
    // and divisible by m
    static int closestNumber(int n, int m) {
        // find the quotient
        int q = n / m;

        // 1st possible closest number
        int n1 = m * q;

        // 2nd possible closest number
        int n2 = (n * m) > 0 ? (m * (q + 1)) : (m * (q - 1));

        // if true, then n1 is the required closest number
        if (Math.abs(n - n1) < Math.abs(n - n2))
            return n1;

        // else n2 is the required closest number
        return n2;
    }

    // Driver program to test above
    public static void main(String args[]) {
        int n = 13, m = 4;
        System.out.println(closestNumber(n, m));

        n = -15;
        m = 6;
        System.out.println(closestNumber(n, m));

        n = 0;
        m = 8;
        System.out.println(closestNumber(n, m));

        n = 18;
        m = -7;
        System.out.println(closestNumber(n, m));
    }
}