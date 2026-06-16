class Solution {
    public void make(int i, int j, int[][] board, int[][] newboard) {
        int ctr = 0;
        int r = board.length;
        int c = board[0].length;

        // Directions array for the 8 neighbors (row_offset, col_offset)
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},        {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };

        // Count live neighbors
        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            if (newRow >= 0 && newRow < r && newCol >= 0 && newCol < c && board[newRow][newCol] == 1) {
                ctr++;
            }
        }

        // Apply the rules of the Game of Life
        if (board[i][j] == 1) { // live cell
            if (ctr < 2 || ctr > 3) {
                newboard[i][j] = 0; // dies
            } else {
                newboard[i][j] = 1; // lives
            }
        } else { // dead cell
            if (ctr == 3) {
                newboard[i][j] = 1; // becomes live
            } else {
                newboard[i][j] = 0; // stays dead
            }
        }
    }

    public void gameOfLife(int[][] board) {
        int r = board.length;
        int c = board[0].length;
        int[][] newboard = new int[r][c];

        // Apply the make function to every cell in the grid
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                make(i, j, board, newboard);
            }
        }

        // Copy newboard back to board
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                board[i][j] = newboard[i][j];
            }
        }
    }
}
