import java.io.*;
import java.util.*;

class Solution {

  private int timer = 1;

  private void dfs(
    int node,
    int parent,
    int[] vis,
    ArrayList<ArrayList<Integer>> adj,
    int tin[],
    int low[],
    List<List<Integer>> bridges
  ) {
    vis[node] = 1;
    tin[node] = low[node] = timer;
    timer++;
    for (Integer it : adj.get(node)) {
      if (it == parent) continue;
      if (vis[it] == 0) {
        dfs(it, node, vis, adj, tin, low, bridges);
        low[node] = Math.min(low[node], low[it]);
        // node --- it
        if (low[it] > tin[node]) {
          bridges.add(Arrays.asList(it, node));
        }
      } else {
        low[node] = Math.min(low[node], low[it]);
      }
    }
  }

  public List<List<Integer>> criticalConnections(
    int n,
    List<List<Integer>> connections
  ) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<Integer>());
    }
    for (List<Integer> it : connections) {
      int u = it.get(0);
      int v = it.get(1);
      adj.get(u).add(v);
      adj.get(v).add(u);
    }
    int[] vis = new int[n];
    int[] tin = new int[n];
    int[] low = new int[n];
    List<List<Integer>> bridges = new ArrayList<>();
    dfs(0, -1, vis, adj, tin, low, bridges);
    return bridges;
  }
}

class Main {

  public static void main(String[] args) {
    int n = 4;
    int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 0 }, { 1, 3 } };
    List<List<Integer>> connections = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      connections.add(new ArrayList<Integer>());
    }
    for (int i = 0; i < n; i++) {
      connections.get(i).add(edges[i][0]);
      connections.get(i).add(edges[i][1]);
    }

    Solution obj = new Solution();
    List<List<Integer>> bridges = obj.criticalConnections(n, connections);

    int size = bridges.size();
    for (int i = 0; i < size; i++) {
      int u = bridges.get(i).get(0);
      int v = bridges.get(i).get(1);
      System.out.print("[" + u + ", " + v + "] ");
    }
    System.out.println("");
  }
}
