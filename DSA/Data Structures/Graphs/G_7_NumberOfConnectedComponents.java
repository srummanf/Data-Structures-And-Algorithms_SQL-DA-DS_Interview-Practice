import java.util.*;

class G_7_NumberOfConnectedComponents {

  private static void dfs(
    int node,
    ArrayList<ArrayList<Integer>> adjLs,
    int vis[]
  ) {
    vis[node] = 1;
    for (int it : adjLs.get(node)) {
      if (vis[it] == 0) {
        dfs(it, adjLs, vis);
      }
    }
  }

  public int findCircleNum(int[][] isConnected) {
    ArrayList<ArrayList<Integer>> adjLs = new ArrayList<ArrayList<Integer>>();
    int V = isConnected[0].length;
    for (int i = 0; i < V; i++) {
      adjLs.add(new ArrayList<Integer>());
    }

    // to change adjacency matrix to list
    for (int i = 0; i < V; i++) {
      for (int j = 0; j < V; j++) {
        // self nodes are not considered
        if (isConnected[i][j] == 1 && i != j) {
          adjLs.get(i).add(j);
          adjLs.get(j).add(i);
        }
      }
    }

    int vis[] = new int[V];
    int cnt = 0;
    for (int i = 0; i < V; i++) {
      if (vis[i] == 0) {
        cnt++;
        dfs(i, adjLs, vis);
      }
    }
    return cnt;
  }
}
