// We have used Kahn Algorithm
/**
 * 1. Find the topo sort
 */

import java.io.*;
import java.util.*;

class LongestPathinDAG {

  public int[] topoSort(int N, ArrayList<ArrayList<Integer>> adj) {
    int[] topo = new int[N];
    int[] indegree = new int[N];

    // Finding Indegree
    for (int i = 0; i < N; i++) {
      for (Integer destNode : adj.get(i)) {
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
      topo[idx] = node;
      idx++;

      // Getting neighbour nodes of popped node and decreasing their indegree by 1
      for (Integer it : adj.get(node)) {
        indegree[it]--;
        if (indegree[it] == 0) {
          q.add(it);
        }
      }
    }

    return topo;
  }

  public int longestPathInDAG(int N, ArrayList<ArrayList<Integer>> adj) {
    int[] topo = topoSort(N, adj);
    int[] dist = new int[N];
    Arrays.fill(dist, Integer.MIN_VALUE);

    // Assuming the source is node 0 (can be changed as per requirements)
    dist[0] = 0;

    for (int i = 0; i < N; i++) {
      int node = topo[i];
      if (dist[node] != Integer.MIN_VALUE) {
        for (Integer neighbor : adj.get(node)) {
          if (dist[neighbor] < dist[node] + 1) {
            dist[neighbor] = dist[node] + 1;
          }
        }
      }
    }

    int longestPath = 0;
    for (int d : dist) {
      if (d != Integer.MIN_VALUE) {
        longestPath = Math.max(longestPath, d);
      }
    }

    return longestPath;
  }

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    // Adding new arraylists to 'adj' to add neighbour nodes
    for (int i = 0; i < 6; i++) {
      adj.add(new ArrayList<>());
    }

    adj.get(5).add(2);
    adj.get(5).add(0);
    adj.get(4).add(0);
    adj.get(4).add(1);
    adj.get(3).add(1);
    adj.get(2).add(3);

    LongestPathinDAG solution = new LongestPathinDAG();
    int longestPathLength = solution.longestPathInDAG(6, adj);
    System.out.println(
      "The length of the longest path is: " + longestPathLength
    );
  }
}
