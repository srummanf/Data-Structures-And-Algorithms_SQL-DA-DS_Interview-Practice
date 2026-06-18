class RangeQuery {
    private int[] segmentTree;
    private int n;

    void buildSegmentTree(int i, int l, int r, int[] arr) {
        if (l == r) {
            segmentTree[i] = arr[l];
            return;
        }
        int mid = l + (r - l) / 2;
        buildSegmentTree(2 * i + 1, l, mid, arr);
        buildSegmentTree(2 * i + 2, mid + 1, r, arr);
        segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
    }

    public RangeQuery(int[] nums) {
        n = nums.length;
        segmentTree = new int[4 * n];
        buildSegmentTree(0, 0, n - 1, nums);
    }

    public int sumRange(int left, int right) {
        return querySegmentTree(left, right, 0, 0, n - 1);
    }

    int querySegmentTree(int start, int end, int i, int l, int r) {
        // Case 1: Out of Bound
        if (l > end || r < start) {
            return 0;
        }

        // Case 2: Completely within the range
        if (l >= start && r <= end) {
            return segmentTree[i];
        }

        // Case 3: Overlapping
        int mid = l + (r - l) / 2;
        return querySegmentTree(start, end, 2 * i + 1, l, mid) +
               querySegmentTree(start, end, 2 * i + 2, mid + 1, r);
    }
}