/** Given an integer array nums, handle multiple queries of the following types:

Update the value of an element in nums.
Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
void update(int index, int val) Updates the value of nums[index] to be val.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 

Example 1:

Input
["NumArray", "sumRange", "update", "sumRange"]
[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
Output
[null, 9, null, 8]

Explanation
NumArray numArray = new NumArray([1, 3, 5]);
numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
numArray.update(1, 2);   // nums = [1, 2, 5]
numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8 */

class NumArray {
    private int[] segmentTree;
    private int[] nums;
    private int n;

    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        segmentTree = new int[4 * n];
        buildSegmentTree(0, 0, n - 1, nums);
    }

    private void buildSegmentTree(int root, int l, int r, int[] nums) {
        if (l == r) {
            segmentTree[root] = nums[l];
            return;
        }
        int mid = l + (r - l) / 2;
        buildSegmentTree(2 * root + 1, l, mid, nums);
        buildSegmentTree(2 * root + 2, mid + 1, r, nums);
        segmentTree[root] = segmentTree[2 * root + 1] + segmentTree[2 * root + 2];
    }

    private void updateSegmentTree(int idx, int val, int root, int l, int r) {
        if (l == r) {
            segmentTree[root] = val;
            return;
        }
        int mid = l + (r - l) / 2;
        if (idx <= mid) {
            updateSegmentTree(idx, val, 2 * root + 1, l, mid);
        } else {
            updateSegmentTree(idx, val, 2 * root + 2, mid + 1, r);
        }
        segmentTree[root] = segmentTree[2 * root + 1] + segmentTree[2 * root + 2];
    }

    public void update(int index, int val) {
        nums[index] = val;
        updateSegmentTree(index, val, 0, 0, n - 1);
    }

    private int querySegmentTree(int start, int end, int root, int l, int r) {
        if (l > end || r < start) {
            return 0;
        }
        if (l >= start && r <= end) {
            return segmentTree[root];
        }
        int mid = l + (r - l) / 2;
        return querySegmentTree(start, end, 2 * root + 1, l, mid) +
               querySegmentTree(start, end, 2 * root + 2, mid + 1, r);
    }

    public int sumRange(int left, int right) {
        return querySegmentTree(left, right, 0, 0, n - 1);
    }
}
