import java.util.*;

class ifPathExistsInGraph {

  /**
   * Recursive helper function to check if a path exists between two vertices.
   *
   * @param vis   A boolean array to keep track of visited vertices.
   * @param graph The adjacency list representation of the graph.
   * @param src   The current vertex being visited during the traversal.
   * @param dest  The destination vertex we are looking for.
   * @return true if a path exists from `src` to `dest`, false otherwise.
   */
  public boolean isPath(
    boolean[] vis,
    ArrayList<Integer>[] graph,
    int src,
    int dest
  ) {
    // If the current vertex is the destination, we have found a valid path
    if (src == dest) return true;

    // Mark the current vertex as visited
    vis[src] = true;

    // Explore all the neighbors of the current vertex
    for (int neighbor : graph[src]) {
      // If the neighbor is not visited
      if (!vis[neighbor]) {
        // Recursively check if a path exists from the neighbor to the destination
        if (isPath(vis, graph, neighbor, dest)) {
          return true;
        }
      }
    }

    // If no path is found from the current vertex to the destination, return false
    return false;
  }

  /**
   * Determines if there is a valid path from the source vertex to the destination vertex.
   *
   * @param n           The number of vertices in the graph.
   * @param edges       The edges in the graph represented as a 2D integer array.
   * @param source      The source vertex.
   * @param destination The destination vertex.
   * @return true if there is a valid path from `source` to `destination`, false otherwise.
   */
  public boolean validPath(int n, int[][] edges, int source, int destination) {
    // Create an adjacency list representation of the graph
    ArrayList<Integer>[] graph = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }

    // Add edges to the adjacency list
    for (int[] edge : edges) {
      int v1 = edge[0];
      int v2 = edge[1];
      graph[v1].add(v2);
      graph[v2].add(v1);
    }

    // Create a boolean array to track visited vertices
    boolean[] vis = new boolean[n];

    // Call the recursive helper function to check if a path exists
    return isPath(vis, graph, source, destination);
  }
}
