### Skeleton Code for A* Algorithm

Here's a reusable skeleton code for the A* algorithm in Java. You can adapt this for various pathfinding or state search problems:

```java
import java.util.*;

public class AStarAlgorithm {

    // Define the node class
    static class Node {
        String state;
        int g; // Cost from start to this node
        int h; // Heuristic cost to goal
        int f; // Total cost (g + h)

        Node(String state, int g, int h) {
            this.state = state;
            this.g = g;
            this.h = h;
            this.f = g + h;
        }
    }

    // Main method to run the A* algorithm
    public static int aStar(String start, String goal, Map<String, List<String>> neighbors, HeuristicFunction heuristic) {
        PriorityQueue<Node> openList = new PriorityQueue<>(Comparator.comparingInt(n -> n.f));
        Set<String> closedList = new HashSet<>();

        openList.offer(new Node(start, 0, heuristic.estimate(start, goal)));
        while (!openList.isEmpty()) {
            Node current = openList.poll();
            if (current.state.equals(goal)) {
                return current.g;
            }

            closedList.add(current.state);
            for (String neighbor : neighbors.get(current.state)) {
                if (closedList.contains(neighbor)) continue;

                int tentativeG = current.g + 1; // Assuming each move has a cost of 1
                int h = heuristic.estimate(neighbor, goal);
                Node neighborNode = new Node(neighbor, tentativeG, h);

                if (!openList.contains(neighborNode) || tentativeG < neighborNode.g) {
                    openList.offer(neighborNode);
                }
            }
        }

        return -1; // No path found
    }

    // Interface for heuristic function
    interface HeuristicFunction {
        int estimate(String state, String goal);
    }
}
```

### When to Use A* Algorithm

The A* algorithm is particularly useful in scenarios where:

1. **Pathfinding**: Finding the shortest path in a grid or graph, such as in maps or games.
2. **State Space Search**: When you need to explore possible states to find an optimal solution, like in puzzle games or route planning.
3. **Heuristic-guided Search**: When you have a good heuristic that can efficiently guide the search toward the goal.

### LeetCode Questions

Here are some LeetCode problems where you can apply the A* algorithm or practice similar pathfinding concepts:

1. **[The Maze II](https://leetcode.com/problems/the-maze-ii/)** - A classic maze problem where you need to find the shortest path to the destination.
2. **[Sliding Puzzle](https://leetcode.com/problems/sliding-puzzle/)** - A puzzle problem where A* can help find the least number of moves to solve the puzzle.
3. **[Shortest Path in Binary Matrix](https://leetcode.com/problems/shortest-path-in-binary-matrix/)** - Finding the shortest path in a binary matrix, where A* can be useful.
4. **[Word Ladder II](https://leetcode.com/problems/word-ladder-ii/)** - While this problem is typically solved with BFS, A* can be adapted for optimized performance with a suitable heuristic.
5. **[Minimum Cost to Move Chips to The Same Position](https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/)** - A problem where you can use A* to optimize the movement cost.

These problems can help you understand and implement the A* algorithm in various contexts and optimize your pathfinding solutions.
