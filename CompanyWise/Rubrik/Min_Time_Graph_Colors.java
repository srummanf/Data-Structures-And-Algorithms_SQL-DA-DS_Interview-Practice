/*
   Time Complexity: O(V + E)
   Space Complexity: O(V)

   Where V is the number of vertices and E is the number of edges in the given tree.

*/

import java.util.*;
public class Solution{

    public static boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> colour, int D, int[] countR, int[] countB, int[] countG, ArrayList<Boolean> vis) {

        // Mark all nodes in shortest path to true.
        vis.set(node, true);
        // Update colour count in the path.
        int currentNodeColour = colour.get(node-1);
        countR[0] += (currentNodeColour == 0 ? 1 : 0);
        countB[0] += (currentNodeColour == 1 ? 1 : 0);
        countG[0] += (currentNodeColour == 2 ? 1 : 0);

        if (node == D) {
            return true;
        }

        boolean foundInNodeSubtree = false;
        for (int it : adj.get(node)) {
            if (!vis.get(it)) {
                foundInNodeSubtree = (foundInNodeSubtree || dfs(it, adj, colour, D, countR, countB, countG, vis));
            }

            if (foundInNodeSubtree) {
                // If destination node(D) is found, stop doing DFS further and return.
                break;
            }
        }

        if (!foundInNodeSubtree) {
            // Remove node from shortest path and restore colour count.
            vis.set(node, false);
            countR[0] -= (currentNodeColour == 0 ? 1 : 0);
            countB[0] -= (currentNodeColour == 1 ? 1 : 0);
            countG[0] -= (currentNodeColour == 2 ? 1 : 0);

            return false;
        }

        else {
            return true;
        }
        
    }

    public static int multisourceBFS(ArrayList<Integer> colour, ArrayList<ArrayList<Integer>> adj, int bfsFromColour, ArrayList<Boolean> vis, int V) {

        int res = 0;
        Queue<Integer> q = new LinkedList();
        Map<Integer, Boolean> visitedNode = new HashMap<>();
        // Push values into queue as start nodes at t=0 for BFS.
        for (int i = 1; i <= colour.size(); i++) {
            if (colour.get(i-1) == bfsFromColour) {
                q.add(i);
                visitedNode.put(i, true);
            }
        }


        int dist = 1;
        while (q.size() > 0) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int curr = q.peek();
                q.remove();
                // For all nodes adjacent to curr, and check if already visited or are in the shortest path.
                // If neighbours unvisited, push them into q and mark visited = true.
                // Or if a neighbour is already vis in shortest path, then return dist.
                for (int it : adj.get(curr)) {
                    if (vis.get(it)) {
                        return dist;
                    }

                    if (visitedNode.containsKey(it) && visitedNode.get(it)) {
                        continue;
                    }

                    visitedNode.put(it, true);
                    q.add(it);
                }

            }

            dist++;
        }

        return dist;
}
    
    public static int minimumTimeToReachDestination(int V, int E, ArrayList<Integer> colour, int[][] edge, int S, int D) {

        // Converting edges to adj list.
        ArrayList<ArrayList<Integer>>adj = new ArrayList<ArrayList<Integer>>(V+1);
        for(int i=0;i<V+1;i++){
            adj.add(new ArrayList<Integer>());
        }
		
        for (int i = 0; i < E; i++)
        {
            adj.get(edge[i][0]).add(edge[i][1]);
            adj.get(edge[i][1]).add(edge[i][0]);
            
        }

        // Create a visited array.
        ArrayList<Boolean> vis = new ArrayList(V+1);
        for(int i=0;i<V+1;i++){
            vis.add(false);
        }
        
        // Create count variables to store count of R, B, G nodes in the shortest path from S to D.
        int[] countR = {0}, countB = {0}, countG = {0};
        // Mark all the nodes as visited lying in the shortest path from S to D in the given tree.
        //  Do the dfs from S node till you find D node.
        dfs(S, adj, colour, D, countR, countB, countG, vis);
		
        // Now we will have all nodes in shortest path marked as visited(true).
        // Check for count of each of coloured balls (R, G, B) should be > 0.
        // If yes, then answer is equal to number of visited(true) nodes - 1 + 3(waiting time at one node each of (R, G, B)).
        if (countR[0] > 0 && countB[0] > 0 && countG[0] > 0) {
            int soln = (countR[0] + countB[0] + countG[0] - 1) + (3);
            return soln;
        }

        int soln = (countR[0] + countB[0] + countG[0] - 1);
        if (countR[0] > 0) {
            soln += 1;
        }

        if (countG[0] > 0) {
            soln += 1;
        }

        if (countB[0] > 0) {
            soln += 1;
        }

        if (countR[0] == 0) {
            // Apply multisource BFS from all red nodes to calculate minm distance red coloured node from visited shortest path from S to D.
            int distRedNode = multisourceBFS(colour, adj, 0, vis, V);
            soln += 2 * distRedNode + 1;
        }

        if (countB[0] == 0) {
            // Apply multisource BFS from all blue nodes to calculate minm distance blue coloured node from visited shortest path from S to D.
            int distBlueNode = multisourceBFS(colour, adj, 1, vis, V);
            soln += 2 * distBlueNode + 1;
        }

        if (countG[0] == 0) {
            // Apply multisource BFS from all green nodes to calculate minm distance green coloured node from visited shortest path from S to D.
            int distGreenNode = multisourceBFS(colour, adj, 2, vis, V);
            soln += 2 * distGreenNode + 1;
        }

        return soln;
        
    }	
}