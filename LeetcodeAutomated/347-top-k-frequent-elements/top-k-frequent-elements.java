class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // 1. Count Frequencies using HashMap
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : nums) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }

        // 2. Create a MinHeap based out of frequencies
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int i : hm.keySet()) {
            pq.add(new int[] { i, hm.get(i) });

            if (pq.size() > k)
                pq.poll();
        }

        int[] ans = new int[k];

        for(int i=0; i<k; i++){
            ans[i] = pq.poll()[0]; // To get the key value
        }

        return ans;
    }
}