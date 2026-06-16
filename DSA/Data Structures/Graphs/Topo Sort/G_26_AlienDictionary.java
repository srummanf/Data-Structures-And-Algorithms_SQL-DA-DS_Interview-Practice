import java.util.*;

class Solution {
    public String findOrder(String[] dict, int n, int k) {
        // Create adjacency list for the graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph by comparing adjacent words
        for (int i = 0; i < n - 1; i++) {
            String w1 = dict[i];
            String w2 = dict[i + 1];
            int min = Math.min(w1.length(), w2.length());
            boolean foundDifference = false;

            for (int j = 0; j < min; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adj.get(w1.charAt(j) - 'a').add(w2.charAt(j) - 'a');
                    foundDifference = true;
                    break;  // Stop comparing after finding the first different character
                }
            }

            // Edge case: if w2 is a prefix of w1, the dictionary order is invalid
            if (!foundDifference && w1.length() > w2.length()) {
                return ""; // Invalid input, no valid order possible
            }
        }

        return topoSort(k, adj);
    }

    public String topoSort(int N, ArrayList<ArrayList<Integer>> adj) {
        StringBuilder topo = new StringBuilder(); // Use StringBuilder for efficient string concatenation
        int[] indegree = new int[N];

        // Calculate indegrees of all nodes
        for (int i = 0; i < N; i++) {
            for (int destNode : adj.get(i)) {
                indegree[destNode]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // Add all nodes with indegree = 0 to the queue
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0; // To detect cycles in the graph
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.append((char)(node + 'a'));
            count++;

            // For each neighbor, reduce its indegree and add to queue if indegree becomes 0
            for (int ngh : adj.get(node)) {
                indegree[ngh]--;
                if (indegree[ngh] == 0) {
                    q.add(ngh);
                }
            }
        }

        // If we couldn't process all nodes, there is a cycle, and no valid order exists
        if (count != N) {
            return ""; // Cycle detected
        }

        return topo.toString();
    }
}
