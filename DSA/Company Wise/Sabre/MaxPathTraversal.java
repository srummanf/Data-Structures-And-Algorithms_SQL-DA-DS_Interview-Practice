/** You are given an m x n grid filled with characters O and X. The character O represents a path that can be traversed, while X represents an obstacle that blocks the path. You start at the top-left corner of the grid, located at position (0,0).

Your task is to determine the maximum number of cells you can traverse starting from (0,0), following these rules:

You can move in all four directions: up, down, left, and right. Diagonal movements are not allowed.
You cannot traverse through or onto an X.
You cannot revisit any cell during a single traversal.
Given the grid, return the maximum number of cells that can be traversed. If the starting cell (0,0) is blocked by an X, the output should be 0.

Input:

A 2D character array grid of size m x n where each element is either 'O' (a traversable cell) or 'X' (an obstacle).
Output:

An integer representing the maximum number of cells that can be traversed from (0,0).
Example:

Input:
grid = [
    ['x', 'o', 'o', 'o', 'o', 'o'],
    ['o', 'x', 'o', 'o', 'o', 'o'],
    ['o', 'o', 'x', 'o', 'o', 'o'],
    ['o', 'o', 'o', 'x', 'o', 'o'],
    ['o', 'o', 'o', 'o', 'x', 'o'],
    ['o', 'o', 'o', 'o', 'o', 'x']
]

Output: 15

Explanation:
Starting from (0,0), the maximum number of cells that can be traversed without crossing any obstacles is 15.

Input:
grid = [
    ['x', 'o', 'o', 'o', 'o', 'o'],
    ['o', 'x', 'o', 'o', 'o', 'o'],
    ['o', 'o', 'x', 'o', 'o', 'o'],
    ['o', 'o', 'o', 'x', 'o', 'o'],
    ['o', 'o', 'o', 'o', 'x', 'o'],
    ['o', 'o', 'o', 'o', 'o', 'o']
]

Output: 21

Explanation:
In this configuration, starting from (0,0), all 21 cells can be traversed, as there is a continuous path connecting them all. */


public class MaxPathTraversal {
    private static int maxCount = 0;

    public static void main(String[] args) {
        char[][] matrix = {
            {'x', 'o', 'o', 'o', 'o', 'o'},
            {'o', 'x', 'o', 'o', 'o', 'o'},
            {'o', 'o', 'x', 'o', 'o', 'o'},
            {'o', 'o', 'o', 'x', 'o', 'o'},
            {'o', 'o', 'o', 'o', 'x', 'o'},
            {'o', 'o', 'o', 'o', 'o', 'x'}
        };
        System.out.println(maxCellsTraversed(matrix)); // Example 1 Output: 15

        char[][] matrix2 = {
            {'x', 'o', 'o', 'o', 'o', 'o'},
            {'o', 'x', 'o', 'o', 'o', 'o'},
            {'o', 'o', 'x', 'o', 'o', 'o'},
            {'o', 'o', 'o', 'x', 'o', 'o'},
            {'o', 'o', 'o', 'o', 'x', 'o'},
            {'o', 'o', 'o', 'o', 'o', 'o'}
        };
        System.out.println(maxCellsTraversed(matrix2)); // Example 2 Output: 21
    }

    public static int maxCellsTraversed(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        maxCount = 0;
        traverse(matrix, visited, 0, 0, 0);
        return maxCount;
    }

    private static void traverse(char[][] matrix, boolean[][] visited, int i, int j, int count) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Check if the current cell is out of bounds or not a path or already visited
        if (i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] == 'x' || visited[i][j]) {
            return;
        }

        // Mark the current cell as visited
        visited[i][j] = true;

        // Update the maximum count of cells traversed
        count++;
        maxCount = Math.max(maxCount, count);

        // Traverse in all four directions: up, down, left, right
        traverse(matrix, visited, i + 1, j, count); // Down
        traverse(matrix, visited, i - 1, j, count); // Up
        traverse(matrix, visited, i, j + 1, count); // Right
        traverse(matrix, visited, i, j - 1, count); // Left

        // Backtrack: mark the current cell as unvisited
        visited[i][j] = false;
    }
}
