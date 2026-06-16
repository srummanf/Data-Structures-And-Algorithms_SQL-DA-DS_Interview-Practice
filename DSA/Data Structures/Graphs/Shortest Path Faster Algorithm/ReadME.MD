# Optimised Bellman Ford Algorithm

SPFA is essentially an optimized version of the Bellman-Ford algorithm using a priority queue to efficiently fetch the next node to process.

### SPFA Implementation(Key Difference from Dijkstra Algo - We dont need to make AdjList)

```java
import java.util.*;

class G_41_SPFA {
    public double[] spfa(int n, int[][] edges, double[] weights, int start) {
        // Distance array
        double[] dist = new double[n];
        Arrays.fill(dist, Double.MAX_VALUE);
        dist[start] = 0.0;

        // PriorityQueue for SPFA (min-heap based on distance)
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(a.dist, b.dist));
        pq.offer(new Pair(start, 0.0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            double currentDist = curr.dist;

            if (currentDist > dist[u])
                continue;

            // Process all adjacent edges
            for (int i = 0; i < edges.length; i++) {
                int[] edge = edges[i];
                int uEdge = edge[0];
                int vEdge = edge[1];
                double weight = weights[i];
              
                if (u == uEdge) { // Process edge if it starts from node u
                    if (dist[u] + weight < dist[vEdge]) {
                        dist[vEdge] = dist[u] + weight;
                        pq.offer(new Pair(vEdge, dist[vEdge]));
                    }
                }
            }
        }

        // Print the shortest paths
        printPaths(start, dist);

        return dist;
    }

    private void printPaths(int start, double[] dist) {
        System.out.println("Shortest paths from node " + start + ":");
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Double.MAX_VALUE) {
                System.out.println("Distance to node " + i + " is Infinity");
            } else {
                System.out.println("Distance to node " + i + ": " + dist[i]);
            }
        }
    }

    private static class Pair {
        int node;
        double dist;

        Pair(int node, double dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        G_41_SPFA sol = new G_41_SPFA();
        int n = 5; // Number of nodes
        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 3},
            {3, 1} // Example edges
        };
        double[] weights = {
            1.0,
            -1.0,
            -1.0,
            -1.0 // Corresponding weights
        };

        int start = 0;
        double[] dist = sol.spfa(n, edges, weights, start);
      
        System.out.println("Shortest distances from node " + start + ":");
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Double.MAX_VALUE) {
                System.out.println("Distance to node " + i + " is Infinity");
            } else {
                System.out.println("Distance to node " + i + ": " + dist[i]);
            }
        }
    }
}
```

### Key Differences:

1. **Priority Queue**: SPFA uses a priority queue to always expand the node with the shortest distance found so far.
2. **Initialization**: The distance array `dist` is initialized to `Double.MAX_VALUE` to represent infinity, which is more appropriate for floating-point weights.
3. **Edge Relaxation**: We only relax the edges that start from the current node `u`. This reduces unnecessary work compared to Bellman-Ford’s full edge relaxation.

### Summary

- **SPFA** is more efficient in practice than Bellman-Ford for many cases and uses a priority queue to dynamically fetch the next node with the shortest path estimate.
- **Handling Negative Weights**: SPFA can handle graphs with negative weights but still cannot handle negative weight cycles properly. If negative weight cycles are a concern, additional checks are required.

### Dijkstra's Algorithm Implementation

```java
import java.util.*;

class G_41_Dijkstra {
    public double[] dijkstra(int n, int[][] edges, double[] weights, int start) {
        // Distance array
        double[] dist = new double[n];
        Arrays.fill(dist, Double.MAX_VALUE);
        dist[start] = 0.0;

        // PriorityQueue for Dijkstra's (min-heap based on distance)
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(a.dist, b.dist));
        pq.offer(new Pair(start, 0.0));

        // Adjacency list for the graph
        Map<Integer, List<Pair>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double weight = weights[i];
            adjList.get(u).add(new Pair(v, weight));
        }

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            double currentDist = curr.dist;

            if (currentDist > dist[u])
                continue;

            // Process all adjacent nodes
            for (Pair neighbor : adjList.get(u)) {
                int v = neighbor.node;
                double weight = neighbor.dist;
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }

        // Print the shortest paths
        printPaths(start, dist);

        return dist;
    }

    private void printPaths(int start, double[] dist) {
        System.out.println("Shortest paths from node " + start + ":");
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Double.MAX_VALUE) {
                System.out.println("Distance to node " + i + " is Infinity");
            } else {
                System.out.println("Distance to node " + i + ": " + dist[i]);
            }
        }
    }

    private static class Pair {
        int node;
        double dist;

        Pair(int node, double dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        G_41_Dijkstra sol = new G_41_Dijkstra();
        int n = 5; // Number of nodes
        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 3},
            {3, 4}
        };
        double[] weights = {
            10.0,
            20.0,
            30.0,
            40.0
        };

        int start = 0;
        double[] dist = sol.dijkstra(n, edges, weights, start);
      
        System.out.println("Shortest distances from node " + start + ":");
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Double.MAX_VALUE) {
                System.out.println("Distance to node " + i + " is Infinity");
            } else {
                System.out.println("Distance to node " + i + ": " + dist[i]);
            }
        }
    }
}
```

### Key Differences Between SPFA and Dijkstra's Algorithm

1. **Graph Representation**:

   - **SPFA**: Uses a list of edges and directly processes edges. Adjacency list is not required.
   - **Dijkstra's Algorithm**: Constructs an adjacency list to store neighbors and their weights.
2. **Edge Relaxation**:

   - **SPFA**: Checks all edges from the current node and updates distances if a shorter path is found.
   - **Dijkstra's Algorithm**: Checks only neighbors from the current node and updates distances if a shorter path is found.
3. **Priority Queue Behavior**:

   - **SPFA**: Uses a priority queue to store nodes with their current shortest distance estimates. Nodes are processed based on the shortest path found so far.
   - **Dijkstra's Algorithm**: Similar use of a priority queue to process nodes with the shortest distance. Ensures that nodes are processed in increasing order of their shortest path distance.
4. **Handling Negative Weights**:

   - **SPFA**: Can handle negative weights but not negative weight cycles.
   - **Dijkstra's Algorithm**: Assumes all edge weights are non-negative and is not suitable for graphs with negative weights.
5. **Time Complexity**:

   - **SPFA**: \(O(V \cdot E)\) in the worst case but often faster in practice.
   - **Dijkstra's Algorithm**: \(O((V + E) \log V)\) with a priority queue (min-heap).
6. **Initialization and Relaxation**:

   - **SPFA**: Directly relaxes edges and updates distances. Can dynamically adjust based on the current node's edges.
   - **Dijkstra's Algorithm**: Uses a priority queue to always expand the node with the smallest known distance. Relies on adjacency lists for efficient edge relaxation.

### Summary

- **SPFA** is more generalized and can handle negative weights, making it more flexible in some scenarios but potentially slower in the worst case.
- **Dijkstra’s Algorithm** is efficient and specifically designed for graphs with non-negative weights, making it faster in practice for such graphs.

Both algorithms are used to solve the shortest path problem but are chosen based on the properties of the graph and the requirements of the problem.
