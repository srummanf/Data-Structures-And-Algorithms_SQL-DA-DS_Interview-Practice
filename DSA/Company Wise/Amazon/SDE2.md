# Minimum Fuel Cost to Report to the Capital

## Problem

There is an Amazon logistics transportation network consisting of `n` warehouses numbered from `0` to `n - 1`, connected by exactly `n - 1` bidirectional roads.

- Warehouse `0` is the central hub.
- Each warehouse has one representative.
- Every warehouse owns a vehicle with seating capacity `seats`.
- Representatives may switch vehicles at any warehouse.
- Traveling along one road consumes **1 liter** of fuel.

Return the **minimum liters of fuel** required for all representatives to reach warehouse `0`.

---

## Key Observation

Since the graph contains exactly `n - 1` roads, it is a **tree**.

Every representative must eventually move towards the capital through the unique path to the root.

Instead of deciding vehicle movements explicitly, compute **how many people flow through every edge**.

For every subtree:

- Count the total representatives inside it.
- Send them to the parent.
- Number of cars needed:

\[
\text{cars}=\left\lceil\frac{\text{people}}{\text{seats}}\right\rceil
\]

Each car crosses exactly **one edge**, so fuel consumed at that edge equals the number of cars.

---

## Algorithm

1. Build an adjacency list.
2. Perform DFS from node `0`.
3. Every DFS returns the number of representatives in its subtree.
4. For every non-root node:

   - Compute

   ```
   cars = ceil(people / seats)
   ```

   or

   ```java
   (people + seats - 1) / seats
   ```
5. Add this value to the answer.
6. Return total fuel.

---

## Java Code

```java
import java.util.*;

class Solution {
    long fuel = 0;
    List<Integer>[] graph;
    int seats;

    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        this.seats = seats;

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] road : roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }

        dfs(0, -1);

        return fuel;
    }

    private long dfs(int node, int parent) {
        long people = 1;

        for (int next : graph[node]) {
            if (next == parent)
                continue;

            people += dfs(next, node);
        }

        if (node != 0) {
            fuel += (people + seats - 1) / seats;
        }

        return people;
    }
}
```

---

## Complexity Analysis

| Complexity | Value          |
| ---------- | -------------- |
| Time       | **O(n)** |
| Space      | **O(n)** |

---

# Maximum Time to Burn a Binary Tree

## Problem

A binary tree is given.

Initially, one node catches fire at time `t = 0`.

Every second, fire spreads from a burning node to all directly connected nodes:

- Left child
- Right child
- Parent

Return the **maximum time** required to burn the entire tree.

---

## Key Observation

Fire spreads exactly like **Breadth First Search (BFS)** on an undirected graph.

The binary tree only stores child pointers, so first we must build parent pointers.

Then perform BFS starting from the fire node.

Each BFS level represents **1 second**.

The answer is simply the number of BFS levels minus one.

---

## Algorithm

1. Traverse the tree once to store every node's parent.
2. Start BFS from the fire node.
3. Keep a visited set.
4. At every level:
   - Visit left child.
   - Visit right child.
   - Visit parent.
5. Increase time after processing each level.
6. Return total time.

---

## Java Code

```java
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

class Solution {

    public int burnTree(Node root, Node fireNode) {

        Map<Node, Node> parent = new HashMap<>();
        buildParent(root, null, parent);

        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        queue.offer(fireNode);
        visited.add(fireNode);

        int time = -1;

        while (!queue.isEmpty()) {

            int size = queue.size();
            time++;

            while (size-- > 0) {

                Node curr = queue.poll();

                if (curr.left != null && visited.add(curr.left))
                    queue.offer(curr.left);

                if (curr.right != null && visited.add(curr.right))
                    queue.offer(curr.right);

                Node par = parent.get(curr);

                if (par != null && visited.add(par))
                    queue.offer(par);
            }
        }

        return time;
    }

    private void buildParent(Node node, Node par, Map<Node, Node> parent) {

        if (node == null)
            return;

        parent.put(node, par);

        buildParent(node.left, node, parent);
        buildParent(node.right, node, parent);
    }
}
```

---

## Complexity Analysis

| Complexity | Value          |
| ---------- | -------------- |
| Time       | **O(n)** |
| Space      | **O(n)** |

---

## Example

```
      b
     / \
    x   a
   / \
  y   z
```

Suppose fire starts from **a**.

```
t = 0 : a

t = 1 : b

t = 2 : x

t = 3 : y, z
```

Therefore,

**Maximum Time = 3 seconds.**


> Source : [https://leetcode.com/discuss/post/8355272/amazon-sde2-by-harsh6489-u2z4/](https://leetcode.com/discuss/post/8355272/amazon-sde2-by-harsh6489-u2z4/ "Amazon SDE2")
