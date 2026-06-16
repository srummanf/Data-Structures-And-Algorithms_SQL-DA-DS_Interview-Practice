/*You are given four integers sx, sy, fx, fy, and a non-negative integer t.

In an infinite 2D grid, you start at the cell (sx, sy). Each second, you must move to any of its adjacent cells.

Return true if you can reach cell (fx, fy) after exactly t seconds, or false otherwise.

A cell's adjacent cells are the 8 cells around it that share at least one corner with it. You can visit the same cell several times. */

import java.util.*;

public class CellReachable {

  public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
    int h = Math.abs(fx - sx);
    int v = Math.abs(fy - sy);

    if (h == 0 && v == 0 && t == 1) return false;

    int maxval = Math.max(h, v);

    if (t >= maxval) return true;

    return false;
  }

  public static void main(String[] args) {
    CellReachable t = new CellReachable();
    System.out.println(t.isReachableAtTime(1, 1, 3, 4, 3));
  }
}
