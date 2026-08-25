/** Problem Description: Find the kth largest element in an array. */
/** Tp have the first k elements
 * Step 1: add in pq
 * step 2: if size>k, remove the top element
 * step 3: return the top element
 */


import java.util.PriorityQueue;

class PQ1_KthLargestElementInArray{
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

    public static void main(String[] args) {
        PQ1_KthLargestElementInArray obj = new PQ1_KthLargestElementInArray();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(obj.findKthLargest(nums, k)); // Output: 5
    }
}