// Floyd Warshall Algorithm is used to find Minimum Distance FROM EACH NODE TO ALL NODES which is better than applying Dijsktra in all the nodes



import java.util.*;



class Solution {
    // Floyd-Warshall algorithm to find the shortest paths between all pairs of nodes
    public int[][] floydWarshall(int n, int[][] edges) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            dist[u][v] = Math.min(dist[u][v], weight);  // Handle multiple edges
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        return dist;
    }

    // Main method to find the minimum cost to convert source to target
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = 26; // Fixed number of nodes for lowercase English letters
        int[][] mat = new int[original.length][3];
        for (int i = 0; i < original.length; i++) {
            mat[i][0] = original[i] - 'a';
            mat[i][1] = changed[i] - 'a';
            mat[i][2] = cost[i];
        }

        int[][] dist = floydWarshall(n, mat);

        long totalCost = 0;

        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i)) {
                int start = source.charAt(i) - 'a';
                int end = target.charAt(i) - 'a';
                int minCost = dist[start][end];
                if (minCost == Integer.MAX_VALUE) return -1;
                totalCost += minCost;
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String source1 = "abcd";
        String target1 = "acbe";
        char[] original1 = {'a', 'b', 'c', 'c', 'e', 'd'};
        char[] changed1 = {'b', 'c', 'b', 'e', 'b', 'e'};
        int[] cost1 = {2, 5, 5, 1, 2, 20};
        System.out.println(solution.minimumCost(source1, target1, original1, changed1, cost1)); // Output: 28

        // Test case 2
        String source2 = "aaaa";
        String target2 = "bbbb";
        char[] original2 = {'a', 'c'};
        char[] changed2 = {'c', 'b'};
        int[] cost2 = {1, 2};
        System.out.println(solution.minimumCost(source2, target2, original2, changed2, cost2)); // Output: 12

        // Test case 3
        String source3 = "abcd";
        String target3 = "abce";
        char[] original3 = {'a'};
        char[] changed3 = {'e'};
        int[] cost3 = {10000};
        System.out.println(solution.minimumCost(source3, target3, original3, changed3, cost3)); // Output: -1
    }
}


// 1 based indexing
class Solution {
    public int networkDelayTime(int[][] edges, int n, int src) {
        int[][] dist = new int[n + 1][n + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            dist[u][v] = Math.min(dist[u][v], weight); // Handle multiple edges
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (dist[src][i] == Integer.MAX_VALUE) {
                return -1; // If any node is unreachable from the source
            }
            ans = Math.max(ans, dist[src][i]);
        }

        return ans;
    }
}