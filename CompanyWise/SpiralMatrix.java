import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
      
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
       
        int[] directionRow = {0, 1, 0, -1};
        int[] directionCol = {1, 0, -1, 0};
      
        int row = 0, col = 0;
      
        int directionIndex = 0;
      
        List<Integer> result = new ArrayList<>();
    
        boolean[][] visited = new boolean[rowCount][colCount];

        for (int h = rowCount * colCount; h > 0; --h) {
            result.add(matrix[row][col]);
            visited[row][col] = true;
            
            int nextRow = row + directionRow[directionIndex];
            int nextCol = col + directionCol[directionIndex];
            
            if (nextRow < 0 || nextRow >= rowCount || nextCol < 0 || nextCol >= colCount || visited[nextRow][nextCol]) {
                
                directionIndex = (directionIndex + 1) % 4;
                
                nextRow = row + directionRow[directionIndex];
                nextCol = col + directionCol[directionIndex];
            }
    
            row = nextRow;
            col = nextCol;
        }
        return result;
    }
}
