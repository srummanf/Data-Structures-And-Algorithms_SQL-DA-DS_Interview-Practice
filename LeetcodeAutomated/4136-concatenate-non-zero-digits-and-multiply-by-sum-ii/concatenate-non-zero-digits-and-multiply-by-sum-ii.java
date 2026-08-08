class Solution {

    static final long MOD = 1_000_000_007L;

    class Node {
        long sum;
        long concat;
        int cnt;

        Node() {}

        Node(long sum, long concat, int cnt) {
            this.sum = sum;
            this.concat = concat;
            this.cnt = cnt;
        }
    }

    Node[] tree;
    long[] pow10;
    String s;

    Node merge(Node left, Node right) {

        Node res = new Node();

        res.sum = left.sum + right.sum;

        res.cnt = left.cnt + right.cnt;

        res.concat = (left.concat * pow10[right.cnt]) % MOD;
        res.concat = (res.concat + right.concat) % MOD;

        return res;
    }

    void build(int idx, int l, int r) {

        if (l == r) {

            int d = s.charAt(l) - '0';

            if (d == 0)
                tree[idx] = new Node(0, 0, 0);
            else
                tree[idx] = new Node(d, d, 1);

            return;
        }

        int mid = (l + r) / 2;

        build(idx * 2, l, mid);
        build(idx * 2 + 1, mid + 1, r);

        tree[idx] = merge(tree[idx * 2], tree[idx * 2 + 1]);
    }

    Node query(int idx, int l, int r, int ql, int qr) {

        if (ql <= l && r <= qr)
            return tree[idx];

        if (r < ql || l > qr)
            return new Node(0, 0, 0);

        int mid = (l + r) / 2;

        Node left = query(idx * 2, l, mid, ql, qr);
        Node right = query(idx * 2 + 1, mid + 1, r, ql, qr);

        return merge(left, right);
    }

    public int[] sumAndMultiply(String s, int[][] queries) {

        this.s = s;

        int n = s.length();

        tree = new Node[4 * n + 5];

        pow10 = new long[n + 1];

        pow10[0] = 1;

        for (int i = 1; i <= n; i++)
            pow10[i] = (pow10[i - 1] * 10) % MOD;

        build(1, 0, n - 1);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            Node res = query(
                    1,
                    0,
                    n - 1,
                    queries[i][0],
                    queries[i][1]);

            ans[i] = (int) ((res.sum * res.concat) % MOD);
        }

        return ans;
    }
}