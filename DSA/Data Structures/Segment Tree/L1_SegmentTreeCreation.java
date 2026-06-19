
import java.util.*;

public class L1_SegmentTreeCreation {
    static void buildSegmentTree(int idx, int l, int r,
                                 int[] segmentTree, int[] arr) {

        // Leaf Node
        if (l == r) {
            segmentTree[idx] = arr[l];
            return;
        }

        int mid = l + (r - l) / 2;

        // Build Left Subtree
        buildSegmentTree(2 * idx + 1, l, mid, segmentTree, arr);

        // Build Right Subtree
        buildSegmentTree(2 * idx + 2, mid + 1, r, segmentTree, arr);

        // Store Sum
        segmentTree[idx] = segmentTree[2 * idx + 1]
                         + segmentTree[2 * idx + 2];
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;

        int[] segmentTree = new int[4 * n];

        buildSegmentTree(0, 0, n - 1, segmentTree, arr);

        System.out.println(Arrays.toString(segmentTree));
    }
}
