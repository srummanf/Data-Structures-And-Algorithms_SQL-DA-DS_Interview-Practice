// declare the cases where condition fails
 // declare cases where condition passes
 // mark visited

 // since return type is there so do in this fashion

  // unvisit them AT THE LAST

  // if not found return false


class Solution {
    public boolean isPossible(int i, int j, int k, int m, int n, int[][] vis, char[][] board, String word, String curr) {
        if (i < 0 || i >= m || j < 0 || j >= n || vis[i][j] == 1 || word.charAt(k) != board[i][j]) {
            return false;
        }
        if (k == word.length() - 1 && word.charAt(k) == board[i][j]) {
            return true;
        }
        vis[i][j] = 1;

        boolean found = false;

        // down --> i+1, j
        found = isPossible(i + 1, j, k + 1, m, n, vis, board, word, curr + word.charAt(k));
        if (found) return true;

        // up --> i-1, j
        found = isPossible(i - 1, j, k + 1, m, n, vis, board, word, curr + word.charAt(k));
        if (found) return true;

        // left --> i, j-1
        found = isPossible(i, j - 1, k + 1, m, n, vis, board, word, curr + word.charAt(k));
        if (found) return true;

        // right --> i, j+1
        found = isPossible(i, j + 1, k + 1, m, n, vis, board, word, curr + word.charAt(k));
        if (found) return true;

        // Unmark this cell as visited -- BackTrack
        vis[i][j] = 0;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        String curr = "";
        int m = board.length;
        int n = board[0].length;
        int vis[][] = new int[m][n];
        
        // Start DFS from each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isPossible(i, j, 0, m, n, vis, board, word, curr)) {
                    return true;
                }
            }
        }

        return false;
    }
}
