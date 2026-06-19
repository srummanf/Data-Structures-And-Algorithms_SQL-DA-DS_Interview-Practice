
public class L3_RangeQuery {
    static void buildSegmentTree(int idx, int l, int r,
                                 int[] segmentTree, int[] arr) {

        if (l == r) {
            segmentTree[idx] = arr[l];
            return;
        }

        int mid = l + (r - l) / 2;

        buildSegmentTree(2 * idx + 1, l, mid, segmentTree, arr);
        buildSegmentTree(2 * idx + 2, mid + 1, r, segmentTree, arr);

        segmentTree[idx] = segmentTree[2 * idx + 1]
                         + segmentTree[2 * idx + 2];
    }

    static int rangeQuery(int start, int end,
                          int idx, int l, int r,
                          int[] segmentTree) {

        // Case 1: No Overlap
        if (l > end || r < start) {
            return 0;
        }

        // Case 2: Complete Overlap
        if (l >= start && r <= end) {
            return segmentTree[idx];
        }

        // Case 3: Partial Overlap
        int mid = l + (r - l) / 2;

        int leftSum = rangeQuery(start, end,
                                 2 * idx + 1,
                                 l, mid,
                                 segmentTree);

        int rightSum = rangeQuery(start, end,
                                  2 * idx + 2,
                                  mid + 1, r,
                                  segmentTree);

        return leftSum + rightSum;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;

        int[] segmentTree = new int[4 * n];

        buildSegmentTree(0, 0, n - 1, segmentTree, arr);

        // Query [1,3] (0-based indexing)
        System.out.println(rangeQuery(1, 3, 0, 0, n - 1, segmentTree));

        // Query [0,4]
        System.out.println(rangeQuery(0, 4, 0, 0, n - 1, segmentTree));
    }
}
