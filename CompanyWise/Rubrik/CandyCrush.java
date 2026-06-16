/** This problem requires you to simulate the game "Candy Crush". Given a 2D grid representing a candy board of size m x n, where each cell contains an integer that represents a different type of candy, your task is to implement an algorithm that performs a series of crushing actions according to the game's rules.

The crushing rules are as follows:

When three or more candies of the same type are adjacent either vertically or horizontally, they all get crushed at once, and their positions are set to zero, indicating an empty cell.
Once candies are crushed, gravity comes into play. Any candies above the empty cells will fall down to fill the empty spaces.
New candies do not enter the board from the top. Only existing candies drop down.
The crushing and dropping process continues until no more crushing can occur—i.e., no groups of three or more adjacent candies of the same type are left.
The goal is to keep applying these rules until the board reaches a stable state with no more possible crushes. The final stable board should be returned. */
class Solution {
    public int[][] candyCrush(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        boolean shouldContinue = true;

        // Loop until no more candies can be crushed
        while (shouldContinue) {
            shouldContinue = false;

            // Mark candies that need to be crushed in the horizontal direction
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < cols - 2; ++j) {
                    int value = Math.abs(board[i][j]);
                    if (value != 0 && value == Math.abs(board[i][j + 1]) && value == Math.abs(board[i][j + 2])) {
                        shouldContinue = true;
                        board[i][j] = board[i][j + 1] = board[i][j + 2] = -value;
                    }
                }
            }

            // Mark candies that need to be crushed in the vertical direction
            for (int j = 0; j < cols; ++j) {
                for (int i = 0; i < rows - 2; ++i) {
                    int value = Math.abs(board[i][j]);
                    if (value != 0 && value == Math.abs(board[i + 1][j]) && value == Math.abs(board[i + 2][j])) {
                        shouldContinue = true;
                        board[i][j] = board[i + 1][j] = board[i + 2][j] = -value;
                    }
                }
            }
          
            // Crush the candies and let new ones fall down
            if (shouldContinue) {
                for (int j = 0; j < cols; ++j) {
                    // Start from bottom of the board
                    int writeIndex = rows - 1;
                    for (int i = rows - 1; i >= 0; --i) {
                        // If this candy is not marked to be crushed, bring it down
                        if (board[i][j] > 0) {
                            board[writeIndex][j] = board[i][j];
                            writeIndex--;
                        }
                    }
                    // Fill the remaining spaces with 0s to indicate empty spaces
                    while (writeIndex > -1) {
                        board[writeIndex][j] = 0;
                        writeIndex--;
                    }
                }
            }
        }

        return board;
    }
}