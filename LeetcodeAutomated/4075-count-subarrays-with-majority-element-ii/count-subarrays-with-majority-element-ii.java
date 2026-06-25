class Solution {
    static class SegmentTree {
        int[] tree;
        int n;

        SegmentTree(int n) {
            this.n = n;
            tree = new int[4 * n];
        }

        void update(int node, int start, int end, int idx) {
            if (start == end) {
                tree[node]++;
                return;
            }

            int mid = (start + end) / 2;

            if (idx <= mid)
                update(2 * node, start, mid, idx);
            else
                update(2 * node + 1, mid + 1, end, idx);

            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }

        int query(int node, int start, int end, int l, int r) {
            if (r < start || end < l)
                return 0;

            if (l <= start && end <= r)
                return tree[node];

            int mid = (start + end) / 2;

            return query(2 * node, start, mid, l, r)
                    + query(2 * node + 1, mid + 1, end, l, r);
        }
    }

    static long countMajoritySubarrays(int[] nums, int target) {

        int n = nums.length;

        // Step 1: Prefix sums
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : -1);
        }

        // Step 2: Coordinate Compression
        int[] sorted = prefix.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> compress = new HashMap<>();
        int id = 0;

        for (int x : sorted) {
            if (!compress.containsKey(x))
                compress.put(x, id++);
        }

        // Step 3: Segment Tree
        SegmentTree st = new SegmentTree(id);

        long ans = 0;

        for (int x : prefix) {

            int idx = compress.get(x);

            // Count previous prefix sums smaller than current
            if (idx > 0)
                ans += st.query(1, 0, id - 1, 0, idx - 1);

            // Insert current prefix
            st.update(1, 0, id - 1, idx);
        }

        return ans;
    }

    // public static void main(String[] args) {

    //     int[] nums = {2, 1, 2};
    //     int target = 2;

    //     System.out.println(countMajoritySubarrays(nums, target)); // 3

    //     int[] nums2 = {1, 2, 3, 2};

    //     System.out.println(countMajoritySubarrays(nums2, 2));
    // }

    // public long countMajoritySubarrays(int[] nums, int target) {
        
    // }
}