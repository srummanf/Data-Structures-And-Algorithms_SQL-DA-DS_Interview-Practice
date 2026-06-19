public class L3_RangeSumQuery {
    private int[] segmentTree;
    private int n;

    // Constructor to initialize the segment tree with the given array
    public L3_RangeSumQuery(int[] nums) {
        n = nums.length;
        segmentTree = new int[4 * n];
        buildSegmentTree(0, 0, n - 1, nums);
    }

    // Function to build the segment tree
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

    // Function to get the sum of elements in the range [left, right]
    public int sumRange(int left, int right) {
        return querySegmentTree(left, right, 0, 0, n - 1);
    }

    // Function to query the segment tree for the sum in the range [start, end]
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

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11};
        L3_RangeSumQuery obj = new L3_RangeSumQuery(nums);
        System.out.println(obj.sumRange(1, 3)); // Output: 15 (3 + 5 + 7)
        System.out.println(obj.sumRange(0, 5)); // Output: 36 (1 + 3 + 5 + 7 + 9 + 11)
        
    }
}




