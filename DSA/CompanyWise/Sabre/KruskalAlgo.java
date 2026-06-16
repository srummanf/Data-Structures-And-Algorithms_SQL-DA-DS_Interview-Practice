// Asked in OA

/**  Single File Programming Question

Problem Statement


You are given an array of points representing the integer coordinates of some points on a 2D plane. The task is to find the minimum cost to connect all points using Kruskal's Algorithm. 


The cost of connecting two points [xi, yi] and [xj, yj] is the Manhattan distance between them, which is calculated as |xi - xj| + |yi - yj|. There should be exactly one simple path between any two points.
Input format :

The first line of input consists of an integer N, representing the number of points.

The coordinates of the points are represented as a 2D array of points of size N*2, where each row i contains the x-coordinate and y-coordinate of the point i.
Output format :

The output prints the minimum cost to connect all points.
Code constraints :

1 ≤ points.length ≤ 1000

-106 ≤ xi, yi ≤ 106

All pairs (xi, yi) are distinct.
Sample test cases :
Input 1 :

3
3 12
-2 5
-4 1

Output 1 :

18

Input 2 :

5
0 0
2 2
3 10
5 2
7 0

Output 2 :

20 */

import java.util.*;

class Main {
    static class Edge {
        int point1;
        int point2;
        int distance;

        public Edge(int point1, int point2, int distance) {
            this.point1 = point1;
            this.point2 = point2;
            this.distance = distance;
        }
    }

    static class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return false;
            }

            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
    }

    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<Edge> edges = new ArrayList<>();

        // Create all edges with their Manhattan distances
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new Edge(i, j, distance));
            }
        }

        // Sort edges by distance
        edges.sort(Comparator.comparingInt(e -> e.distance));

        UnionFind uf = new UnionFind(n);
        int result = 0;
        int edgesUsed = 0;

        // Kruskal's Algorithm
        for (Edge edge : edges) {
            if (uf.union(edge.point1, edge.point2)) {
                result += edge.distance;
                edgesUsed++;
                if (edgesUsed == n - 1) {
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = scanner.nextInt();
            points[i][1] = scanner.nextInt();
        }
        scanner.close();

        int result = minCostConnectPoints(points);
        System.out.println(result);
    }
}
