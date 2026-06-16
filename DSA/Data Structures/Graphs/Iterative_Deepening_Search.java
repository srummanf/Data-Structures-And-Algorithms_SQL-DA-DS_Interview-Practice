import java.util.*;

class Iterative_Deepening_Search {

    public static boolean dls(int node, ArrayList<ArrayList<Integer>> adjLs, boolean[] vis, int depth) {
        if (depth == 0) {
            if (!vis[node]) {
                System.out.print(node + " ");
                vis[node] = true;
            }
            return true;
        }
        for (int ngh : adjLs.get(node)) {
            if (!vis[ngh]) {
                if (dls(ngh, adjLs, vis, depth - 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void ids(int src, ArrayList<ArrayList<Integer>> adjLs, int maxDepth) {
        boolean[] vis;
        for (int depth = 0; depth <= maxDepth; depth++) {
            vis = new boolean[adjLs.size()];
            System.out.print("Depth " + depth + ": ");
            if (dls(src, adjLs, vis, depth)) {
                System.out.println();
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

        Iterative_Deepening_Search sl = new Iterative_Deepening_Search();
        int src = 0;
        int maxDepth = 3; // Example maximum depth
        ids(src, adj, maxDepth);
    }
}
