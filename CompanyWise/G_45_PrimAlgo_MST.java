/** Spanning Tree - Graph which has N nodes and N-1 edges and we can reach all the nodes from any src node  -- Bi/Un Directional graph*
 *  MST - Spanning Tree with min sum of weights
 */

import java.util.*;

class G_45_PrimAlgo {

  static ArrayList<Integer> wtss = new ArrayList<Integer>();

  // Function to find sum of weights of edges of the Minimum Spanning Tree.
  static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
    // PQ --> {dest_node, weight}
    PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);

    int[] vis = new int[V];
    // {node, wt}
    pq.add(new int[] { 0, 0 });
    int sum = 0;
    while (pq.size() > 0) {
      int[] current = pq.poll();
      int node = current[0];
      int wt = current[1];

      if (vis[node] == 1) continue;
      // add it to the MST
      vis[node] = 1;
      sum += wt;
      wtss.add(wt);

      for (int i = 0; i < adj.get(node).size(); i++) {
        int adjNode = adj.get(node).get(i).get(0);
        int edW = adj.get(node).get(i).get(1);
        if (vis[adjNode] == 0) {
          pq.add(new int[] { adjNode, edW });
        }
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    int V = 5;
    ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

    int[][] edges = {
      { 0, 1, 2 },
      { 0, 2, 1 },
      { 1, 2, 1 },
      { 2, 3, 2 },
      { 3, 4, 1 },
      { 4, 2, 2 },
    };

    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < 6; i++) {
      int u = edges[i][0];
      int v = edges[i][1];
      int w = edges[i][2];

      ArrayList<Integer> tmp1 = new ArrayList<>();
      ArrayList<Integer> tmp2 = new ArrayList<>();
      tmp1.add(v);
      tmp1.add(w);

      tmp2.add(u);
      tmp2.add(w);

      adj.get(u).add(tmp1);
      adj.get(v).add(tmp2);
    }

    G_45_PrimAlgo obj = new G_45_PrimAlgo();
    int sum = obj.spanningTree(V, adj);
    System.out.println("The sum of all the edge weights: " + sum);

    Collections.sort(wtss);
    System.out.println(
      "The diff of max and min weights in MST: " +
      (wtss.get(wtss.size() - 1) - wtss.get(1))
    );

    System.out.println(wtss);
  }
}
