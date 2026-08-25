class Solution {

    public int dist(int[] pt) {
        return pt[0] * pt[0] + pt[1] * pt[1];
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> dist(b) - dist(a));

        for (int[] point : points) {
            queue.offer(point);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }
}