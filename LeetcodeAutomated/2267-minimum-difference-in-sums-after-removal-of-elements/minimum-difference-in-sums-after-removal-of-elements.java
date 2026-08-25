class Solution {
    public long minimumDifference(int[] nums) {
        long ans = Long.MAX_VALUE;

        int N = nums.length;
        int n = N / 3;

        long[] leftMinSum = new long[N];
        long[] rightMaxSum = new long[N];

        //1. Define the Heaps
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        //2. Calculate the Left Min Sum
        long leftSum = 0;
        for (int i = 0; i < 2 * n; i++) {
            minHeap.add(nums[i]);
            leftSum += nums[i];

            if (minHeap.size() > n) {
                leftSum -= minHeap.poll();
                
            }

            leftMinSum[i] = leftSum;
        }

        //3. Calculate the Right Max Sum
        long rightSum = 0;
        for (int i = N - 1; i >= n; i--) {
            maxHeap.add(nums[i]);
            rightSum += nums[i];

            if (maxHeap.size() > n) {
                rightSum -= maxHeap.poll();
                
            }

            rightMaxSum[i] = rightSum;
        }

        //4. Traverse these cummulative sums to find the minimum difference
        for(int i = n-1; i<2*n; i++){
            ans = Math.min(ans, (leftMinSum[i] - rightMaxSum[i+1]));
        }

        return ans;


    }
}