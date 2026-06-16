/** There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].

A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).

Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order. */

/** To find the safe state(A terminal node which has no outgoing edges /// A node whose every possible path leads to terminal node)  --> Topo Sort for the reversed graph */

import java.util.Collections;
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int nodes = graph.length;
        for (int i = 0; i < nodes; i++) {
            adj.add(new ArrayList<Integer>());
        }
        int idx = 0;
        // Reverse the edge and make the graph and then do a toposort to find the list of safe nodes
        for (int[] row : graph) {
            if (row.length >= 1)
                for (int a : row) {
                    adj.get(a).add(idx);
                }
            idx++;
        }
        List<Integer> topo = topoSort(nodes, adj);
        System.out.println(topo);
        Collections.sort(topo);
        return topo;

    }

    public List<Integer> topoSort(int N, ArrayList<ArrayList<Integer>> adj) {
        List<Integer> topo = new ArrayList<>();
        int[] indegree = new int[N];

        // Finding Indegree
        for (int i = 0; i < N; i++) {
            for (int destNode : adj.get(i)) {
                indegree[destNode]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // Adding nodes to queue with indegree = 0
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int idx = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            // this node is very important -- for any other questions, use this node only
            topo.add(node);
            idx++;

            // Getting neighbour nodes of popped node and decreasing their indegree by 1
            for (int ngh : adj.get(node)) {
                indegree[ngh]--;
                if (indegree[ngh] == 0) {
                    q.add(ngh);
                }
            }
        }

        return topo;
    }
}