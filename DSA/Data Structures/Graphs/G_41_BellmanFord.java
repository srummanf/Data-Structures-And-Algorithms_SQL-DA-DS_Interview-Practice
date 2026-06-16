// Can detect negative cycles unlike dijkstra

// It is a DP based Algorithm

import java.util.*;

class G_41_BellmanFord {
    public int[] bellmanFord(int n, int[][] edges, int start) {
        // Distance array
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        // Relax all edges (n-1) times
        for (int i = 0; i < n - 1; i++) {
            // Copy code from here for cyc
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int weight = edge[2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        // Check for negative weight cycles
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains a negative weight cycle");
                return null; // Return null if a negative weight cycle is detected
            }
        }

        // Print the shortest paths
        printPaths(start, dist);

        return dist;
    }

    private void printPaths(int start, int[] dist) {
        System.out.println("Shortest paths from node " + start + ":");
        for (int i = 0; i < dist.length; i++) {
            if (i != start) {
                System.out.println("Distance to node " + i + " (Distance: " + dist[i] + ")");
            }
        }
    }

    public static void main(String[] args) {
        G_41_BellmanFord sol = new G_41_BellmanFord();
        int n = 5; // Number of nodes
        // int[][] edges = {
        //     {0, 1, 10},
        //     {0, 4, 3},
        //     {1, 2, 2},
        //     {1, 4, 4},
        //     {2, 3, 9},
        //     {3, 4, 7}
        // };
        int[][] edges = {
            {0, 1, 1},
            {1, 2, -1},
            {2, 3, -1},
            {3, 1, -1} // This edge creates a negative weight cycle
        };

        int start = 0;
        int[] dist = sol.bellmanFord(n, edges, start);
        
        if (dist != null) {
            System.out.println("Shortest distances from node " + start + ":");
            for (int i = 0; i < dist.length; i++) {
                System.out.println("Distance to node " + i + ": " + dist[i]);
            }
        }
    }
}
