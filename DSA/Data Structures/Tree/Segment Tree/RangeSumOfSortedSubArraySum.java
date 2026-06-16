class Solution {
    private static final int MOD = 1_000_000_007;

    public void buildSegmentTree(int i, int l, int r, int[] st, int[] arr) {
        if (l == r) {
            st[i] = arr[l];
            return;
        }
        int mid = l + (r - l) / 2;
        buildSegmentTree(2 * i + 1, l, mid, st, arr);
        buildSegmentTree(2 * i + 2, mid + 1, r, st, arr);
        st[i] = (st[2 * i + 1] + st[2 * i + 2])%MOD;
    }

    int querySegmentTree(
            int start,
            int end,
            int i,
            int l,
            int r,
            int[] segmentTree) {
        // Case 1 : Out of Bound
        if (l > end || r < start) {
            return 0;
        }

        // Case 2 : Completely within the range
        if (l >= start && r <= end) {
            return segmentTree[i];
        }

        // Case 3 : Overlapping
        int mid = l + (r - l) / 2;
        return (querySegmentTree(start, end, 2 * i + 1, l, mid, segmentTree) +
                querySegmentTree(start, end, 2 * i + 2, mid + 1, r, segmentTree)) % MOD;
    }

    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] arr = new int[n * (n + 1) / 2];
        int newlen = n * (n + 1) / 2;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                arr[idx++] = sum;
            }
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int[] segmentTree = new int[5 * newlen];
        buildSegmentTree(0, 0, newlen - 1, segmentTree, arr);
        return querySegmentTree(left - 1, right - 1, 0, 0, newlen - 1, segmentTree);

    }
}   