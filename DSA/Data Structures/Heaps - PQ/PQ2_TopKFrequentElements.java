/** Problem Description: Given an integer array nums and an integer k, return the k most frequent elements. */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class PQ2_TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        int ans[] = new int[k];

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : nums) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }

        int n = hm.size();

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap
                = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        maxHeap.addAll(hm.entrySet());

        for (int i = 0; i < k; i++) {
            ans[i] = maxHeap.poll().getKey();

        }

        return ans;

    }

    public static void main(String[] args) {
        PQ2_TopKFrequentElements obj = new PQ2_TopKFrequentElements();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = obj.topKFrequent(nums, k);
        System.out.print("Top " + k + " frequent elements: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
