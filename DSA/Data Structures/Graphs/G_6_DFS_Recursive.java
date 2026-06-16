/**
 * DFS Steps
 * dfs(node, vis, adj) 
 * vis[node] = true;
 * use the node val (print)
 * for each neighbours, if not visited dfs(ngh, vis, adj)
 */

private void dfs(char[][] grid, boolean[][] vis, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0' || vis[i][j]) {
            return;
        }

        vis[i][j] = true;

        dfs(grid, vis, i + 1, j);
        dfs(grid, vis, i - 1, j);
        dfs(grid, vis, i, j + 1);
        dfs(grid, vis, i, j - 1);
    }


    =============================  x x x x x x x x x x  ===============================


import java.util.*;

class G_6_DFS_Recursive {

  public static void dfs(
    int node,
    ArrayList<ArrayList<Integer>> adjLs,
    boolean[] vis
  ) {
    vis[node] = true;
    System.out.print(node + " ");
    for (int ngh : adjLs.get(node)) {
      if (!vis[ngh]) {
        dfs(ngh, adjLs, vis);
      }
    }
  }

  public static void main(String args[]) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      adj.add(new ArrayList<>());
    }
    adj.get(0).add(1);
    adj.get(1).add(0);
    adj.get(0).add(4);
    adj.get(4).add(0);
    adj.get(1).add(2);
    adj.get(2).add(1);
    adj.get(1).add(3);
    adj.get(3).add(1);

    G_6_DFS_Recursive sl = new G_6_DFS_Recursive();
    int nodes = 5;
    boolean[] vis = new boolean[nodes];
    Arrays.fill(vis, false);
    int src = 0;
    dfs(2, adj, vis);
  }
}
