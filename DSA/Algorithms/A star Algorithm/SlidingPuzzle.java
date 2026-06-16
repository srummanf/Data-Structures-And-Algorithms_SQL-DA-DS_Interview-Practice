/** On an 2 x 3 board, there are five tiles labeled from 1 to 5, and an empty square represented by 0. A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.

The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].

Given the puzzle board board, return the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, return -1.

 

Example 1:


Input: board = [[1,2,3],[4,0,5]]
Output: 1
Explanation: Swap the 0 and the 5 in one move.
Example 2:


Input: board = [[1,2,3],[5,4,0]]
Output: -1
Explanation: No number of moves will make the board solved.
Example 3:


Input: board = [[4,1,2],[5,0,3]]
Output: 5
Explanation: 5 is the smallest number of moves that solves the board.
An example path:
After move 0: [[4,1,2],[5,0,3]]
After move 1: [[4,1,2],[0,5,3]]
After move 2: [[0,1,2],[4,5,3]]
After move 3: [[1,0,2],[4,5,3]]
After move 4: [[1,2,0],[4,5,3]]
After move 5: [[1,2,3],[4,5,0]]
 

Constraints:

board.length == 2
board[i].length == 3
0 <= board[i][j] <= 5
Each value board[i][j] is unique. */

import java.util.*;

class Solution {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static final String TARGET = "123450";
    private static final int ROWS = 2;
    private static final int COLS = 3;

    public int slidingPuzzle(int[][] board) {
        String start = boardToString(board);
        if (start.equals(TARGET)) return 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        Set<String> visited = new HashSet<>();
        pq.offer(new Node(start, 0, heuristic(start)));
        visited.add(start);

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.state.equals(TARGET)) {
                return current.moves;
            }

            int zeroIndex = current.state.indexOf('0');
            int zeroRow = zeroIndex / COLS;
            int zeroCol = zeroIndex % COLS;

            for (int[] dir : DIRS) {
                int newRow = zeroRow + dir[0];
                int newCol = zeroCol + dir[1];
                if (newRow >= 0 && newRow < ROWS && newCol >= 0 && newCol < COLS) {
                    int newIndex = newRow * COLS + newCol;
                    char[] newState = current.state.toCharArray();
                    swap(newState, zeroIndex, newIndex);
                    String newStateStr = new String(newState);

                    if (!visited.contains(newStateStr)) {
                        visited.add(newStateStr);
                        int newMoves = current.moves + 1;
                        int newHeuristic = heuristic(newStateStr);
                        pq.offer(new Node(newStateStr, newMoves, newMoves + newHeuristic));
                    }
                }
            }
        }
        return -1;
    }

    private String boardToString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                sb.append(num);
            }
        }
        return sb.toString();
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int heuristic(String state) {
        int manhattanDistance = 0;
        for (int i = 0; i < state.length(); i++) {
            char ch = state.charAt(i);
            if (ch != '0') {
                int targetX = (ch - '1') / COLS;
                int targetY = (ch - '1') % COLS;
                int currentX = i / COLS;
                int currentY = i % COLS;
                manhattanDistance += Math.abs(currentX - targetX) + Math.abs(currentY - targetY);
            }
        }
        return manhattanDistance;
    }

    private static class Node {
        String state;
        int moves;
        int cost;

        Node(String state, int moves, int cost) {
            this.state = state;
            this.moves = moves;
            this.cost = cost;
        }
    }
}
