/** You are given a graph with 'N' vertices, where each vertex has an assigned integer. You are given 'Q' queries where each query can be of two types:

1 'U' 'V': Reverse the order of all the integers on the path between 'U' and 'V'.
2 'U' 'V': Print the sum of all the integers on the path between 'U' and 'V'.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N,Q <= 10^4
1 <= u,v <= N
1 <= value[i] <= 10^4

Where value[i] represents the value associated with the node.

Time Limit: 1 sec.
Sample Input 1:
12 3
1 2
2 3
3 4
1 5
5 6
5 7
1 8
8 9
9 10
9 11
9 12
10 8 5 9 12 16 8 18 21 11 19 20
2 4 7
1 1 6
2 4 7
Sample Output 1:
52
58
Explanation For Sample Output 1:

In the first query, we have to find the sum of the values of the path between node 4 and node 7. The path between 4 and 7 is 4, 3, 2, 1, 5, 7, and their corresponding height is 9, 5, 8, 10, 12, 8. 
Their sum is 52. So the output is 52.

In the second query, we have to reverse the order of the values on the path between 1 and 6. The path is 1 5 6, and their corresponding values are 10 12 16. After reversing, their values will be 16 12 10. So, the final array will be 16 8 5 9 12 10 8 18 21 11 19 20.

In the third query, we have to find the sum of the values of the path between node 4 and node 7. The path between 4 and 7 is 4, 3, 2, 1, 5, 7, and their corresponding height is 9, 5, 8, 16, 12, 8. 
Their sum is 58. So the output is 58.
 */

import java.util.*;

class HLD {
    static final int MAXN = 10005;
    int N, Q;
    int[] A = new int[MAXN], DEP = new int[MAXN], PAR = new int[MAXN];
    int[] CHAIN = new int[MAXN], SZ = new int[MAXN], HEAD = new int[MAXN];
    int[] IND = new int[MAXN], VERT = new int[MAXN], L = new int[MAXN];
    int[] R = new int[MAXN], VAL = new int[MAXN], SUM = new int[MAXN];
    int[] TSZ = new int[MAXN], ROOT = new int[MAXN];
    boolean[] REV = new boolean[MAXN];
    int chainNum = 0, chainInd = 0, curInd = 0, curNode = 0;
    List<Integer>[] adj = new ArrayList[MAXN];

    public HLD() {
        for (int i = 0; i < MAXN; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    int makeNode(int val) {
        ++curNode;
        SUM[curNode] = VAL[curNode] = val;
        REV[curNode] = false;
        TSZ[curNode] = 1;
        L[curNode] = R[curNode] = 0;
        return curNode;
    }

    void reverse(int x) {
        if (x != 0) REV[x] ^= true;
    }

    void update(int x) {
        if (x != 0) {
            TSZ[x] = 1 + TSZ[L[x]] + TSZ[R[x]];
            SUM[x] = VAL[x] + SUM[L[x]] + SUM[R[x]];
        }
    }

    void propagate(int x) {
        if (x != 0 && REV[x]) {
            reverse(x);
            int temp = L[x];
            L[x] = R[x];
            R[x] = temp;
            reverse(L[x]);
            reverse(R[x]);
        }
    }

    void merge(int[] x, int l, int r) {
        propagate(l);
        propagate(r);
        if (l == 0 || r == 0) {
            x[0] = (l != 0) ? l : r;
        } else {
            merge(L, l, L[r]);
            x[0] = r;
        }
        update(x[0]);
    }

    void split(int x, int[] l, int[] r, int ind) {
        if (x == 0) {
            l[0] = r[0] = 0;
            return;
        }
        propagate(x);
        if (ind <= TSZ[L[x]]) {
            split(L[x], l, L, ind);
            r[0] = x;
        } else {
            split(R[x], R, r, ind - TSZ[L[x]] - 1);
            l[0] = x;
        }
        update(x);
    }

    void dfs(int v, int d, int prev) {
        DEP[v] = d;
        PAR[v] = prev;
        SZ[v] = 1;
        for (int w : adj[v]) {
            if (w == prev) continue;
            dfs(w, d + 1, v);
            SZ[v] += SZ[w];
        }
    }

    void hld(int v, int prev) {
        if (HEAD[chainNum] == -1) {
            HEAD[chainNum] = v;
            chainInd = 0;
        }
        CHAIN[v] = chainNum;
        IND[v] = chainInd++;
        VERT[curInd++] = v;
        int maxInd = -1;
        for (int w : adj[v]) {
            if (w != prev && (maxInd == -1 || SZ[maxInd] < SZ[w])) maxInd = w;
        }
        if (maxInd != -1) hld(maxInd, v);
        for (int w : adj[v]) {
            if (w == prev || w == maxInd) continue;
            chainNum++;
            hld(w, v);
        }
    }

    int lca(int v, int w) {
        while (CHAIN[v] != CHAIN[w]) {
            if (DEP[HEAD[CHAIN[v]]] < DEP[HEAD[CHAIN[w]]]) w = PAR[HEAD[CHAIN[w]]];
            else v = PAR[HEAD[CHAIN[v]]];
        }
        return (DEP[v] < DEP[w]) ? v : w;
    }

    int getLastChainInd(int v, int w) {
        while (CHAIN[v] != CHAIN[w]) v = PAR[HEAD[CHAIN[v]]];
        return IND[v];
    }

    int queryUp(int v, int w, boolean includeW) {
        int ret = 0;
        int[] l = new int[1], m = new int[1], r = new int[1];
        while (CHAIN[v] != CHAIN[w]) {
            split(ROOT[CHAIN[v]], l, r, IND[v] + 1);
            ret += SUM[l[0]];
            merge(ROOT, l, r);
            v = PAR[HEAD[CHAIN[v]]];
        }
        if (!includeW && v == w) return ret;
        split(ROOT[CHAIN[v]], l, r, IND[v] + 1);
        split(l[0], l, m, IND[w] + (includeW ? 0 : 1));
        ret += SUM[m[0]];
        merge(ROOT, l, m);
        merge(ROOT, ROOT, r);
        return ret;
    }

    int queryPath(int v, int w) {
        int lcaVert = lca(v, w);
        return queryUp(v, lcaVert, true) + queryUp(w, lcaVert, false);
    }

    void splitUp(int v, int w, boolean includeW, int[] temp) {
        int[] l = new int[1], m = new int[1], r = new int[1];
        while (CHAIN[v] != CHAIN[w]) {
            split(ROOT[CHAIN[v]], l, ROOT, IND[v] + 1);
            reverse(l[0]);
            merge(temp, temp[0], l[0]);
            v = PAR[HEAD[CHAIN[v]]];
        }
        if (!includeW && v == w) return;
        split(ROOT[CHAIN[v]], l, r, IND[v] + 1);
        split(l[0], l, m, IND[w] + (includeW ? 0 : 1));
        reverse(m[0]);
        merge(temp, temp[0], m[0]);
        merge(ROOT, l[0], r[0]);
    }

    void mergeUp(int v, int w, boolean includeW, int[] temp) {
        int[] l = new int[1], m = new int[1], r = new int[1];
        while (CHAIN[v] != CHAIN[w]) {
            split(temp[0], l, temp, IND[v] + 1);
            reverse(l[0]);
            merge(ROOT, l[0], ROOT);
            v = PAR[HEAD[CHAIN[v]]];
        }
        if (!includeW && v == w) return;
        split(ROOT[CHAIN[v]], l, r, IND[w] + (includeW ? 0 : 1));
        split(temp[0], m, temp, IND[v] - (IND[w] + (includeW ? 0 : 1)) + 1);
        reverse(m[0]);
        merge(ROOT, l[0], m[0]);
        merge(ROOT, ROOT, r[0]);
    }

    void reversePath(int v, int w) {
        int lcaVert = lca(v, w);
        if (getLastChainInd(v, lcaVert) < getLastChainInd(w, lcaVert)) {
            int temp = v;
            v = w;
            w = temp;
        }
        int[] tv = new int[1], tw = new int[1];
        splitUp(v, lcaVert, false, tv);
        splitUp(w, lcaVert, true, tw);
        reverse(tw[0]);
        merge(tv, tv[0], tw[0]);
        reverse(tv[0]);
        mergeUp(v, lcaVert, true, tv);
        reverse(tv[0]);
        mergeUp(w, lcaVert, false, tv);
    }
}

public class Solution {
    public static List<Integer> treeQuery(int n, int q, int[][] edges, int[] val, int[][] queries) {
        HLD obj = new HLD();
        obj.N = n;
        obj.Q = q;

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int a = edges[i][0] - 1;
            int b = edges[i][1] - 1;
            obj.adj[a].add(b);
            obj.adj[b].add(a);
        }

        obj.dfs(0, 0, -1);
        Arrays.fill(obj.HEAD, -1);
        obj.hld(0, -1);

        for (int i = 0; i < n; i++) {
            obj.ROOT[obj.CHAIN[i]] = obj.makeNode(obj.A[obj.VERT[i]]);
        }

        for (int[] query : queries) {
            int type = query[0];
            int a = query[1] - 1;
            int b = query[2] - 1;
            if (type == 1) {
                ans.add(obj.queryPath(a, b));
            } else {
                obj.reversePath(a, b);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // Example usage
        int n = 5;
        int q = 2;
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int[] val = {1, 2, 3, 4, 5};
        int[][] queries = {{1, 1, 5}, {2, 3, 5}};

        List<Integer> result = treeQuery(n, q, edges, val, queries);
        for (int res : result) {
            System.out.println(res);
        }
    }
}
