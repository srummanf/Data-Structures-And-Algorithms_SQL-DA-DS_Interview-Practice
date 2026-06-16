
import java.util.*;
class PathFromSrcToDestUsingBFS {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj, int src) {
        ArrayList<Integer> distance = new ArrayList<>(Collections.nCopies(V, -1)); // Initialize distance with -1
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis[src] = true;
        distance.set(src, 0); // Set distance of source to 0
        while (!q.isEmpty()) {
            int node = q.poll();
            // Get all adjacent vertices of the dequeued vertex; if an adjacent has not been visited, mark it visited and enqueue it
            for (int it : adj.get(node)) {
                if (!vis[it]) {
                    vis[it] = true;
                    distance.set(it, distance.get(node) + 1); // Update distance
                    q.add(it);
                }
            }
        }
        return distance;
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
        PathFromSrcToDestUsingBFS sl = new PathFromSrcToDestUsingBFS();
        int src = 3;
        ArrayList<Integer> ans = sl.bfsOfGraph(5, adj, src);
        int n = ans.size();
        for (int i = 0; i < n; i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
