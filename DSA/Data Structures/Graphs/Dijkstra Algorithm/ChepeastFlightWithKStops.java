/** There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

 

Example 1:


Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
 */
import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Create the adjacency list to represent the graph
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        // Queue to store the current node, the cost so far, and the number of stops made
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0, 0});

        // Distance array to store the minimum cost to reach each node
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // BFS traversal
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int cost = curr[1];
            int stops = curr[2];

            // If the number of stops exceeds k, skip this route
            if (stops > k) continue;

            // Explore the neighbors
            for (int[] neighbor : adj.get(node)) {
                int nextNode = neighbor[0];
                int price = neighbor[1];

                // If a cheaper price is found, update the cost and add the next node to the queue
                if (cost + price < dist[nextNode]) {
                    dist[nextNode] = cost + price;
                    q.add(new int[]{nextNode, dist[nextNode], stops + 1});
                }
            }
        }

        // If the destination is unreachable, return -1
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}


// -- Print paths !!

import java.util.*;

class Solution {

  private int check(int node, int[] parent, int[] price, int k) {
    if (node == -1) return 0;
    if (node == k + 2) return price[node];
    return price[node] + check(parent[node], parent, price, k);
  }

  private void printPaths(int start, int[] parent, int[] price, int k) {
    for (int i = 0; i < parent.length; i++) {
      if (i != start) {
        System.out.println(
          "Price to reach node " + i + " is " + check(i, parent, price, k)
        );
      }
    }
  }

  public int findCheapestPrice(
    int n,
    int[][] flights,
    int src,
    int dst,
    int k
  ) {
    List<List<int[]>> adjList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adjList.add(new ArrayList<>());
    }
    for (int[] flight : flights) {
      int from = flight[0];
      int to = flight[1];
      int price = flight[2];
      adjList.get(from).add(new int[] { to, price });
    }

    int[] dist = new int[n];
    int[] parent = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    Arrays.fill(parent, -1);
    dist[src] = 0;

    // {node, price, stops}
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    pq.offer(new int[] { src, 0, 0 });

    while (!pq.isEmpty()) {
      int[] travel = pq.poll();
      int u = travel[0]; // src node
      int currPrice = travel[1]; // price from src to dst
      int stops = travel[2]; // stops till now

      if (u == dst) return currPrice;

      if (stops > k) continue;

      for (int[] ngh : adjList.get(u)) {
        int v = ngh[0];
        int price = ngh[1];
        if (currPrice + price < dist[v]) {
          dist[v] = currPrice + price;
          parent[v] = u;
          pq.offer(new int[] { v, dist[v], stops + 1 });
        }
      }
    }

    return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
  }
}
