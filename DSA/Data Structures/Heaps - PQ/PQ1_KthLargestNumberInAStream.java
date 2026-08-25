/** Problem Description: Find the kth largest element in a stream of integers. */

import java.util.PriorityQueue;

class PQ1_KthLargestNumberInAStream{
    PriorityQueue<Integer> pq;
    int k;

    public PQ1_KthLargestNumberInAStream(int k, int[] nums) {

        this.k = k;
        this.pq = new PriorityQueue<>();

        for (int n : nums) {

            pq.add(n);

            if (pq.size() > k) {
                pq.poll();
            }
        }
    }

    public int add(int val) {

        pq.add(val);

        if (pq.size() > k) {
            pq.poll();
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2};
        PQ1_KthLargestNumberInAStream kthLargest = new PQ1_KthLargestNumberInAStream(k, nums);
        System.out.println(kthLargest.add(3));   // returns 4
        System.out.println(kthLargest.add(5));   // returns 5
        System.out.println(kthLargest.add(10));  // returns 5
        System.out.println(kthLargest.add(9));   // returns 8
        System.out.println(kthLargest.add(4));   // returns 8
    }
}