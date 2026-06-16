class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    char ch = board[i][j];
                    board[i][j] = '.'; // Temporarily empty the cell to avoid self-check
                    if (!isValid(board, i, j, ch)) {
                        return false;
                    }
                    board[i][j] = ch; // Restore the value
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int r, int c, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[i][c] == ch) {
                return false;
            }
            if (board[r][i] == ch) {
                return false;
            }
            if (board[3 * (r / 3) + i / 3][3 * (c / 3) + i % 3] == ch) {
                return false;
            }
        }
        return true;
    }


}
