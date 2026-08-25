class Solution {
    public int findKthLargest(int[] nums, int k) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // for(int i: nums){
        //     pq.add(i);
        // }

        // for(int i=1; i<k; i++){
        //     pq.remove();
        // }
        
        // return pq.peek();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num:nums){
            pq.add(num);

            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}