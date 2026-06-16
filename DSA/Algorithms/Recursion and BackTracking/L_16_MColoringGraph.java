// Backtracking Solution
/** We want to split a group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other people, and they should not go into the same group.

Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person labeled bi, return true if it is possible to split everyone into two groups in this way.

 

Example 1:

Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: The first group has [1,4], and the second group has [2,3].
Example 2:

Input: n = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Explanation: We need at least 3 groups to divide them. We cannot put them in two groups.
 

Constraints:

1 <= n <= 2000
0 <= dislikes.length <= 104
dislikes[i].length == 2
1 <= ai < bi <= n
All the pairs of dislikes are unique. */


// here M = 2

class Solution {

    // public boolean isPossible(int node, int color, int[][] dislikes, int[] col) {
    // for (int[] i : dislikes) {
    // int parent = i[0];
    // int ngh = i[1];
    // if (parent == node && col[ngh]==color)
    // return false;
    // }
    // return true;
    // }

    public boolean isPossible(int node, int color, int[][] dislikes, int[] col) {
        for (int[] i : dislikes) {
            int u = i[0];
            int v = i[1];
            if (u == node && col[v] == color)
                return false;
            if (v == node && col[u] == color)
                return false;
        }
        return true;
    }

    public boolean coloring(int node, int n, int[][] dislikes, int[] col) {
        // if(node==n) return true wont work as graph is 1 based indexing
        if (node > n)
            return true;
        for (int color = 1; color <= 2; color++) {
            if (isPossible(node, color, dislikes, col)) {
                col[node] = color;
                if (coloring(node + 1, n, dislikes, col))
                    return true;
                col[node] = -1;
            }
        }
        return false;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] col = new int[n + 1];
        return coloring(1, n, dislikes, col);

    }
}