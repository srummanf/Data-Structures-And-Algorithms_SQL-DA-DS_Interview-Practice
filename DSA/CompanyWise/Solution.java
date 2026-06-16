import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  public static ArrayList<Integer> stonesFall(
    int n,
    int m,
    int r,
    int[][] grid,
    int[][] rem
  ) {
    ArrayList<Integer> results = new ArrayList<>();
    int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // Directions for adjacent cells (up, down, left, right)

    for (int[] remove : rem) {
      int i = remove[0];
      int j = remove[1];

      // If there's no stone at the removal location, add 0 to results and continue
      if (grid[i][j] == 0) {
        results.add(0);
        continue;
      }

      // Mark the stone as removed
      grid[i][j] = 0;

      // Use BFS to mark all stones that are still connected to the top
      boolean[][] visited = new boolean[n][m];
      Queue<int[]> queue = new LinkedList<>();
      for (int col = 0; col < m; col++) {
        if (grid[0][col] == 1) {
          queue.add(new int[] { 0, col });
          visited[0][col] = true;
        }
      }

      while (!queue.isEmpty()) {
        int[] cell = queue.poll();
        int x = cell[0], y = cell[1];

        for (int[] dir : directions) {
          int nx = x + dir[0], ny = y + dir[1];
          if (
            nx >= 0 &&
            nx < n &&
            ny >= 0 &&
            ny < m &&
            !visited[nx][ny] &&
            grid[nx][ny] == 1
          ) {
            visited[nx][ny] = true;
            queue.add(new int[] { nx, ny });
          }
        }
      }

      // Count the number of stones that are not connected to the top anymore
      int fallenStones = 0;
      for (int row = 0; row < n; row++) {
        for (int col = 0; col < m; col++) {
          if (grid[row][col] == 1 && !visited[row][col]) {
            fallenStones++;
            grid[row][col] = 0; // Mark as fallen
          }
        }
      }

      results.add(fallenStones);
    }

    return results;
  }

  public static void main(String[] args) {
    // You can test the function here if necessary
  }
}
