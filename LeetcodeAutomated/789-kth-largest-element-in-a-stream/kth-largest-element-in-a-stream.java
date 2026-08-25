// learn the fundamental rule:
// When looking for K largest elements → maintain a min-heap of size K.

class KthLargest {

    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {

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
}