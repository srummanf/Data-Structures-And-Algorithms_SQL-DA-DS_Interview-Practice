/** Kahn Algo : 
 * 1. Find Indegree Array
 * 2. Make a Queue 
 * 3. Add those elements in the Queue whose Indegree == 0 using a loop ---> O(N)
 * 4. Unless Q is empty , Pop the element and save it in a var, push it in topo array
 * 5. For all the neighbours of Node, indegree[ngh]-- , if indegree[ngh]==0 push ngh in Q
 */

import java.io.*;
import java.util.*;

class Solution {

    public int[] topoSort(int N, ArrayList<ArrayList<Integer>> adj) {
        int[] topo = new int[N];
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
            topo[idx] = node;
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

public class G_22_TopoSort_BFS_KahnsAlgo {

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

        int[] topoOrder = new Solution().topoSort(6, adj);
        for (int node : topoOrder) {
            System.out.print(node + " ");
        }
    }
}
