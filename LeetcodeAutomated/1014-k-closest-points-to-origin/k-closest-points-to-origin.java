class Solution {

    public class Point_Dist {
        int a, b;
        double dist;

        Point_Dist(int p, int q, double d) {
            a = p;
            b = q;
            dist = d;
        }
    }

    public double calcDist(int[] pt) {
        return Math.sqrt(
            Math.pow(pt[0], 2) + Math.pow(pt[1], 2)
        );
    }

    public int[][] kClosest(int[][] points, int k) {

        int[][] ans = new int[k][2];

        // Max Heap
        PriorityQueue<Point_Dist> pq =
            new PriorityQueue<>((a, b) -> Double.compare(b.dist, a.dist));

        for (int[] pt : points) {

            double dist = calcDist(pt);

            pq.add(new Point_Dist(pt[0], pt[1], dist));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        for (int i = 0; i < k; i++) {

            Point_Dist p = pq.poll();

            ans[i][0] = p.a;
            ans[i][1] = p.b;
        }

        return ans;
    }
}