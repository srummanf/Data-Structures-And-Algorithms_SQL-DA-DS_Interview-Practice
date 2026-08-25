/** Problem: Find the k closest points to the origin in a 2D plane. */

import java.util.*;

class PQ3_LeastKPoints {
    
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
    
    public static void main(String[] args) {
        PQ3_LeastKPoints solution = new PQ3_LeastKPoints();
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;
        int[][] closestPoints = solution.kClosest(points, k);
        System.out.println("The " + k + " closest points to the origin are:");
        for (int[] point : closestPoints) {
            System.out.println("(" + point[0] + ", " + point[1] + ")");
        }
    }
}























// What I learnt: // Max Heap
//         PriorityQueue<Point_Dist> pq =
//             new PriorityQueue<>((a, b) -> Double.compare(b.dist, a.dist));

/** 
 * class Solution {

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
 */