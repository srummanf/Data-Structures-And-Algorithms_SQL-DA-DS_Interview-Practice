import java.util.*;

class RangeMinQuery {
    private int[] segmentTree;
    private int n;

    public RangeMinQuery(int[] nums) {
        n = nums.length;
        segmentTree = new int[4 * n];
        buildSegmentTree(0, 0, n - 1, nums);
    }

    void buildSegmentTree(int i, int l, int r, int[] arr) {
        if (l == r) {
            segmentTree[i] = arr[l];
            return;
        }
        int mid = l + (r - l) / 2;
        buildSegmentTree(2 * i + 1, l, mid, arr);
        buildSegmentTree(2 * i + 2, mid + 1, r, arr);
        segmentTree[i] = Math.min(segmentTree[2 * i + 1],segmentTree[2 * i + 2]);
    }


    public int minRange(int left, int right) {
        return querySegmentTree(left, right, 0, 0, n - 1);
    }

    int querySegmentTree(int start, int end, int i, int l, int r) {
        // Case 1: Out of Bound
        if (l > end || r < start) {
            return Integer.MAX_VALUE;
        }

        // Case 2: Completely within the range
        if (l >= start && r <= end) {
            return segmentTree[i];
        }

        // Case 3: Overlapping
        int mid = l + (r - l) / 2;
        return Math.min(querySegmentTree(start, end, 2 * i + 1, l, mid) ,
               querySegmentTree(start, end, 2 * i + 2, mid + 1, r));
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 7, 9, 11};
        RangeMinQuery rmq = new RangeMinQuery(arr);
        System.out.println(rmq.minRange(1, 3));  // Output should be 2
        System.out.println(rmq.minRange(0, 5));  // Output should be 1
    }
}