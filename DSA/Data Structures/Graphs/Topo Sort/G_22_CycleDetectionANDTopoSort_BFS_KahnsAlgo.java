/** Kahn Algo : 
 * 1. Find Indegree Array
 * 2. Make a Queue 
 * 3. Add those elements in the Queue whose Indegree == 0 using a loop ---> O(N)
 * 4. Unless Q is empty , Pop the element and save it in a var, push it in topo array
 * 5. For all the neighbours of Node, indegree[ngh]-- , if indegree[ngh]==0 push ngh in Q
 */

import java.io.*;
import java.lang.*;
import java.util.*;

class Solution {

  public boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
    
    int topo[] = new int[N];
    int indegree[] = new int[N];

    // Finding Indegree
    for (int i = 0; i < N; i++) {
      for (Integer destNode : adj.get(i)) {
        indegree[destNode]++;
      }
    }

    Queue<Integer> q = new LinkedList<Integer>();

    // Adding nodes to queue with indegree = 0
    for (int i = 0; i < N; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }

    int cnt = 0;
    int ind = 0;

    while (!q.isEmpty()) {
      Integer node = q.poll();
      topo[ind++] = node;
      cnt++;
      //getting neighbour nodes of popped node and decreasing  their indegree by1
      for (Integer it : adj.get(node)) {
        indegree[it]--;
        if (indegree[it] == 0) {
          q.add(it);
        }
      }
    }
    //printing topological ordering of nodes
    for (int i = 0; i < topo.length; i++) {
      System.out.print(topo[i] + " ");
    }

    // Checking for Cycle -- If cnt == N means NOT A CYCLE , hence false
    if (cnt == N) return false;
    return true;
  }
}

public class G_22_CycleDetectionANDTopoSort_BFS_KahnsAlgo {

  public static void main(String args[]) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    // adding new arraylists to 'adj' to add neighbour nodes
    for (int i = 0; i < 6; i++) {
      adj.add(new ArrayList<>());
    }

    adj.get(5).add(2);
    adj.get(5).add(0);
    adj.get(4).add(0);
    adj.get(4).add(1);
    adj.get(3).add(1);
    adj.get(2).add(3);

    new Solution().isCyclic(6, adj);
  }
}
