import java.util.*;

class G_21_TopoSort_DFS {

  public static void dfs(
    int node,
    ArrayList<ArrayList<Integer>> adj,
    int[] vis,
    Stack<Integer> st
  ) {
    vis[node] = 1;
    for (int neighbour : adj.get(node)) {
      if (vis[neighbour] == 0) {
        dfs(neighbour, adj, vis, st);
      }
    }
    st.push(node);
  }

  public static void topoSort(int n, ArrayList<ArrayList<Integer>> adj) {
    Stack<Integer> st = new Stack<>();
    int[] vis = new int[n];
    for (int i = 0; i < n; i++) {
      if (vis[i] == 0) {
        dfs(i, adj, vis, st);
      }
    }

    int[] topo = new int[n];
    int idx = 0;
    while (!st.isEmpty()) {
      topo[idx++] = st.pop();
    }
    for (int i = 0; i < n; i++) System.out.println(topo[i] + " ");
  }

  public static void main(String args[]) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    int n = 6;
    for (int i = 0; i < n; i++) {
      ArrayList<Integer> arr = new ArrayList<>();
      adj.add(arr);
    }

    adj.get(5).add(2);
    adj.get(5).add(0);
    adj.get(4).add(0);
    adj.get(4).add(1);
    adj.get(2).add(3);
    adj.get(3).add(1);

    topoSort(6, adj);
  }
}
