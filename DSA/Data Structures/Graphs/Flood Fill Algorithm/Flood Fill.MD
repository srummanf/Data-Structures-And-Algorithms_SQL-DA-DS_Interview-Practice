# Flood Fill Algorithm

## Overview

The Flood Fill algorithm is used to fill a connected region of pixels or nodes with a new color or value. It is commonly used in computer graphics and image processing to replace or fill a contiguous area of pixels with a new color.

## Algorithm

The Flood Fill algorithm can be implemented using two primary techniques:

1. **Depth-First Search (DFS):**

   - Start from a given node (or pixel) and recursively visit all connected nodes with the same original color.
   - Replace the color of the current node and continue the process for all its neighbors.
2. **Breadth-First Search (BFS):**

   - Use a queue to iteratively visit all connected nodes with the same original color.
   - Replace the color of the current node and add its neighbors to the queue.

### DFS Implementation

```java
public class FloodFill {
    public static void floodFillDFS(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) return;
        fillDFS(image, sr, sc, oldColor, newColor);
    }

    private static void fillDFS(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor) {
            return;
        }
        image[sr][sc] = newColor;
        fillDFS(image, sr + 1, sc, oldColor, newColor);
        fillDFS(image, sr - 1, sc, oldColor, newColor);
        fillDFS(image, sr, sc + 1, oldColor, newColor);
        fillDFS(image, sr, sc - 1, oldColor, newColor);
    }
}
```

```markdown

```

### BFS Implementation

```java
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public static void floodFillBFS(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) return;
    
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;
    
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int[] dir : directions) {
                int r = pos[0] + dir[0];
                int c = pos[1] + dir[1];
                if (r >= 0 && r < image.length && c >= 0 && c < image[0].length && image[r][c] == oldColor) {
                    image[r][c] = newColor;
                    queue.offer(new int[]{r, c});
                }
            }
        }
    }
}
```

## Use Cases

1. **Image Processing:**

   - Used to fill or replace contiguous regions of pixels in image editing software (e.g., paint bucket tool in graphic editors).
2. **Graph Traversal:**

   - Applied to find all nodes in a connected component of a graph, useful in various scenarios like network analysis.
3. **Game Development:**

   - Used to implement features like area selection or flood fill effects in games.
4. **Maze Solving:**

   - Helps to find and mark paths or regions within a maze or grid-based problem.

## LeetCode Problems

1. **[Flood Fill](https://leetcode.com/problems/flood-fill/)**

   - **Description:** Given a 2D image and a starting pixel, replace the color of the starting pixel and all its connected pixels with a new color.
   - **Difficulty:** Easy
2. **[Number of Islands](https://leetcode.com/problems/number-of-islands/)**

   - **Description:** Given a 2D grid of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
   - **Difficulty:** Medium
3. **[Surrounded Regions](https://leetcode.com/problems/surrounded-regions/)**

   - **Description:** Given a board with 'X' and 'O', capture all regions surrounded by 'X'. A region is surrounded by 'X' if it is completely enclosed by 'X'.
   - **Difficulty:** Medium
4. **[Flood Fill with Diagonal Movement](https://leetcode.com/problems/flood-fill-with-diagonal-movement/)**

   - **Description:** Similar to the flood fill problem, but allows diagonal movements.
   - **Difficulty:** Medium

---

The Flood Fill algorithm is versatile and can be adapted to various scenarios involving connected regions in a grid or graph. Understanding both DFS and BFS implementations allows for efficient solutions depending on the problem constraints and requirements.
