/**
 * 1. Sort all nodes in order of their finishing time -- TOPO SORT using DFS --> O(N)
 * 2. Transpose the graph(reverse the directions) --> O(N+E)
 * 3. Do DFS on the transpose graph, according to finishing time --> O(N+E)
 */

import java.io.*;
import java.util.*;

//User function Template for Java

class G_54_KosarajuAlgo {

  // TopoSort using DFS function
  private void topoSortUsingDFS(
    int node,
    int[] vis,
    ArrayList<ArrayList<Integer>> adj,
    Stack<Integer> st
  ) {
    vis[node] = 1;
    for (Integer it : adj.get(node)) {
      if (vis[it] == 0) {
        topoSortUsingDFS(it, vis, adj, st);
      }
    }
    st.push(node);
  }

  // DFS function
  private void DFS(int node, int[] vis, ArrayList<ArrayList<Integer>> adjT) {
    vis[node] = 1;
    for (Integer it : adjT.get(node)) {
      if (vis[it] == 0) {
        DFS(it, vis, adjT);
      }
    }
  }

  private void DFS_print(
    int node,
    int[] vis,
    ArrayList<ArrayList<Integer>> adjT
  ) {
    vis[node] = 1;
    System.out.print(node + " ");
    for (Integer it : adjT.get(node)) {
      if (vis[it] == 0) {
        DFS_print(it, vis, adjT);
      } else {
        System.out.print("\n");
      }
    }
  }

  //Function to find number of strongly connected components in the graph.
  public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
    int[] vis = new int[V];
    Stack<Integer> st = new Stack<Integer>();
    
    // Step 1. Sort all nodes in order of their finishing time -- TOPO SORT using DFS --> O(N)
    for (int i = 0; i < V; i++) {
      if (vis[i] == 0) {
        topoSortUsingDFS(i, vis, adj, st);
      }
    }

    // Step 2. Transpose the graph(reverse the directions) --> O(N+E)
    ArrayList<ArrayList<Integer>> adjT = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i < V; i++) {
      adjT.add(new ArrayList<Integer>());
    }
    for (int i = 0; i < V; i++) {
      // Making the vis node to default state;
      vis[i] = 0;
      for (Integer it : adj.get(i)) {
        // i -> it
        // it -> i
        adjT.get(it).add(i);
      }
    }

    // Step 3. Do DFS on the transpose graph, according to finishing time --> O(N+E)
    int scc = 0;
    while (!st.isEmpty()) {
      int node = st.pop();
      if (vis[node] == 0) {
        scc++;
        DFS_print(node, vis, adjT);
        // DFS(node, vis, adjT);
      }
    }
    return scc;
  }

  public static void main(String[] args) {
    int n = 5;
    int[][] edges = { { 1, 0 }, { 0, 2 }, { 2, 1 }, { 0, 3 }, { 3, 4 } };
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<Integer>());
    }
    for (int i = 0; i < n; i++) {
      adj.get(edges[i][0]).add(edges[i][1]);
    }
    G_54_KosarajuAlgo obj = new G_54_KosarajuAlgo();
    int ans = obj.kosaraju(n, adj);
    System.out.println(
      "The number of strongly connected components is: " + ans
    );
  }
}
