/** Given a number of nodes and a list of connected pairs, determine the weights of each isolated set of nodes assuming each node weighs 1 unit. Then for each weight calculated, sum the ceiling of its square root and return the final sum.

Example

graph_nodes = 10

graph_from = [1, 1, 2, 3, 7]

graph_to [2, 3, 4, 5, 8]

3

1

6

7

9

10

2

3

8

4

5

There are graph_edges = 5 edges to consider. There are 2 isolated sets with more than one node, (1, 2, 3, 4, 5) and (7, 8). The ceilings of their square roots are 51/2 2.236 and ceil(2.236) = 3,21/2 1.414 and ceil(1.414)=2. The other three isolated nodes are separate and the square root of their weights is 11/2 = 1 respectively. The sum is 3+2+(3*1)=8.

Complete the function connectedSum in the editor below.

connectedSum has the following parameter(s):

int graph_nodes: the number of nodes int graph_from[graph_edges]: an array of integers that represent one end of an edge

int graph_tograph_edges]: an array of integers that represent the other end of an edge

Returns:

int an integer that denotes the sum of the values calculated

Constraints

2 graph nodes ≤ 105

1graph_edges ≤ 105

1s graph_from[i], graph_to[i] = n

graph_from[i]graph_to[i]
 */

import java.util.*;

public class Solution {
    public static int connectedSum(int graphNodes, List<Integer> graphFrom, List<Integer> graphTo) {
        // Initialize adjacency list with empty lists for each node
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= graphNodes; i++) {
            adjList.add(new ArrayList<>());
        }

        // Populate the adjacency list with edges
        for (int i = 0; i < graphFrom.size(); i++) {
            adjList.get(graphFrom.get(i)).add(graphTo.get(i));
            adjList.get(graphTo.get(i)).add(graphFrom.get(i));
        }

        boolean[] visited = new boolean[graphNodes + 1];
        int totalSum = 0;

        // Traverse each node and calculate connected components
        for (int i = 1; i <= graphNodes; i++) {
            if (!visited[i]) {
                int size = bfs(i, adjList, visited);
                totalSum += Math.ceil(Math.sqrt(size));
            }
        }

        return totalSum;
    }

    // BFS to calculate the size of the connected component
    private static int bfs(int node, List<List<Integer>> adjList, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        int size = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            size++;
            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return size;
    }

    public static void main(String[] args) {
        List<Integer> graphFrom = Arrays.asList(1, 1, 2, 3, 7);
        List<Integer> graphTo = Arrays.asList(2, 3, 4, 5, 8);
        System.out.println(connectedSum(10, graphFrom, graphTo));  // Output: 8
    }
}
