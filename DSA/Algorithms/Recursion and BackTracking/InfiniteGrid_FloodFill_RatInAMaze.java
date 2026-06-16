/** There is a 1 million by 1 million grid on an XY-plane, and the coordinates of each grid square are (x, y).

We start at the source = [sx, sy] square and want to reach the target = [tx, ty] square. There is also an array of blocked squares, where each blocked[i] = [xi, yi] represents a blocked square with coordinates (xi, yi).

Each move, we can walk one square north, east, south, or west if the square is not in the array of blocked squares. We are also not allowed to walk outside of the grid.

Return true if and only if it is possible to reach the target square from the source square through a sequence of valid moves.

 

Example 1:

Input: blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
Output: false
Explanation: The target square is inaccessible starting from the source square because we cannot move.
We cannot move north or east because those squares are blocked.
We cannot move south or west because we cannot go outside of the grid.
Example 2:

Input: blocked = [], source = [0,0], target = [999999,999999]
Output: true
Explanation: Because there are no blocked cells, it is possible to reach the target square.
 

Constraints:

0 <= blocked.length <= 200
blocked[i].length == 2
0 <= xi, yi < 106
source.length == target.length == 2
0 <= sx, sy, tx, ty < 106
source != target
It is guaranteed that source and target are not blocked. */

// Solution : We make a formula = x*base+y --> if we check whether this value is present we return false


import java.util.HashSet;
import java.util.Set;

public class Solution {
    private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    private static final int BASE = (int) 1e6;
    private Set<Integer> blockedSet;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        blockedSet = new HashSet<>();
        for (int[] block : blocked) {
            blockedSet.add(block[0] * BASE + block[1]);
        }

        return isReachable(source, target, new HashSet<>()) && isReachable(target, source, new HashSet<>());
    }

    private boolean isReachable(int[] current, int[] target, Set<Integer> visited) {
        int x = current[0], y = current[1];

        if (x < 0 || x >= BASE || y < 0 || y >= BASE || blockedSet.contains(x * BASE + y)
                || visited.contains(x * BASE + y)) {
            return false;
        }

        visited.add(x * BASE + y);

        if (visited.size() > 20000 || (x == target[0] && y == target[1])) {
            return true;
        }

        // for (int[] direction : DIRECTIONS) {
        // int newX = x + direction[0];
        // int newY = y + direction[1];
        // if (isReachable(new int[] {newX, newY}, target, visited)) {
        // return true;
        // }
        // }

        // Downward
        int newX = x + 1;
        int newY = y;
        if (newX >= 0 && newX < BASE && newY >= 0 && newY < BASE &&
                !blockedSet.contains(newX * BASE + newY) && !visited.contains(newX * BASE + newY)) {
            if (isReachable(new int[] { newX, newY }, target, visited)) {
                return true;
            }
        }

        // Left
        newX = x;
        newY = y - 1;
        if (newX >= 0 && newX < BASE && newY >= 0 && newY < BASE &&
                !blockedSet.contains(newX * BASE + newY) && !visited.contains(newX * BASE + newY)) {
            if (isReachable(new int[] { newX, newY }, target, visited)) {
                return true;
            }
        }

        // Right
        newX = x;
        newY = y + 1;
        if (newX >= 0 && newX < BASE && newY >= 0 && newY < BASE &&
                !blockedSet.contains(newX * BASE + newY) && !visited.contains(newX * BASE + newY)) {
            if (isReachable(new int[] { newX, newY }, target, visited)) {
                return true;
            }
        }

        // Upward
        newX = x - 1;
        newY = y;
        if (newX >= 0 && newX < BASE && newY >= 0 && newY < BASE &&
                !blockedSet.contains(newX * BASE + newY) && !visited.contains(newX * BASE + newY)) {
            if (isReachable(new int[] { newX, newY }, target, visited)) {
                return true;
            }
        }

        return false;
    }
}
