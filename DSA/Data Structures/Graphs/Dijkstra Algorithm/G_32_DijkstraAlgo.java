import java.util.*;

class G_32_DijkstraAlgo {
    public int[] dijkstra(int n, int[][] edges, int start) {

        // 1. Create the adjacency list for the graph
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            adjList.get(u).add(new int[]{v, weight});
            adjList.get(v).add(new int[]{u, weight}); // For undirected graph            edges   only            (  directe
        }

        // 2. Distance and parent arrays
        int[] dist = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        dist[start] = 0;

        // Priority queue to pick the node with the smallest distance
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0}); // {node, distance}

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            int currentDist = current[1];

            if (currentDist > dist[u]) continue;

            // Explore neighbors
            for (int[] neighbor : adjList.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];

                // distance of node + weight < distance to neighbour
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    parent[v] = u;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }

        // Print the shortest paths
        printPaths(start, parent, dist);

        return dist;
    }

    private void printPaths(int start, int[] parent, int[] dist) {
        System.out.println("Shortest paths from node " + start + ":");
        for (int i = 0; i < parent.length; i++) {
            if (i != start) {
                System.out.print("Path to node " + i + " (Distance: " + dist[i] + "): ");
                printPath(i, parent);
                System.out.println();
            }
        }
    }

    private void printPath(int node, int[] parent) {
        if (node == -1) return;
        printPath(parent[node], parent);
        System.out.print(node + " ");
    }

    public static void main(String[] args) {
        G_32_DijkstraAlgo sol = new G_32_DijkstraAlgo();
        int n = 5; // Number of nodes
        int[][] edges = {
            {0, 1, 10},
            {0, 4, 3},
            {1, 2, 2},
            {1, 4, 4},
            {2, 3, 9},
            {3, 4, 7}
        };
        int start = 0;
        int[] dist = sol.dijkstra(n, edges, start);
        
        System.out.println("Shortest distances from node " + start + ":");
        for (int i = 0; i < dist.length; i++) {
            System.out.println("Distance to node " + i + ": " + dist[i]);
        }
    }
}
