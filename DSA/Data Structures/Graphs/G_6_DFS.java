import java.util.*;

class G_6_DFS {

  // Function to return Breadth First Traversal of given graph.
  public ArrayList<Integer> dfsOfGraph(
    int V,
    ArrayList<ArrayList<Integer>> adj,
    int src
  ) {
    ArrayList<Integer> dfs = new ArrayList<>();
    boolean vis[] = new boolean[V];
    Stack<Integer> st = new Stack<>();

    st.push(src);
    vis[src] = true;

    while (!st.isEmpty()) {
      int node = st.pop();
      dfs.add(node);

      // Get all adjacent vertices of the dequeued vertex s
      // If a adjacent has not been visited, then mark it
      // visited and enqueue it
      for (int it : adj.get(node)) {
        if (vis[it] == false) {
          vis[it] = true;
          st.push(it);
        }
      }
    }

    return dfs;
  }

  // TC --> O(Nodes)+O(2*Edges)
  private static void dfs_recursive(
    int node,
    ArrayList<ArrayList<Integer>> adjLs,
    int vis[]
  ) {
    vis[node] = 1;
    System.out.println(node + " ");
    for (int it : adjLs.get(node)) {
      if (vis[it] == 0) {
        dfs_recursive(it, adjLs, vis);
      }
    }
  }

  public static void main(String args[]) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      adj.add(new ArrayList<>());
    }
    adj.get(0).add(2);
    adj.get(2).add(0);
    adj.get(0).add(1);
    adj.get(1).add(0);
    adj.get(0).add(3);
    adj.get(3).add(0);
    adj.get(2).add(4);
    adj.get(4).add(2);

    G_6_DFS sl = new G_6_DFS();
    int src = 0;

    ArrayList<Integer> ans = sl.dfsOfGraph(5, adj, src);
    int n = ans.size();
    for (int i = 0; i < n; i++) {
      System.out.print(ans.get(i) + " ");
    }

    System.out.println("");
    int vis[] = new int[5];
    sl.dfs_recursive(0, adj, vis);
  }
}
