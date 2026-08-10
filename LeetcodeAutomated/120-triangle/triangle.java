// class Solution {

//     public int solve(List<List<Integer>> triangle, int[][] dp, int i, int j, int n){
//         if(dp[i][j] !=-1) return dp[i][j];
//         if(i == n-1) return triangle.get(i).get(j);

      

//         int down = triangle.get(i).get(j) + solve(triangle, dp, i+1, j, n);
//         int down_diag = triangle.get(i).get(j) + solve(triangle, dp, i+1, j+1, n);

//         return dp[i][j] = Math.min(down, down_diag);
//     }
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size();
//         int dp[][] = new int[n][n];
//         for (int row[] : dp)
//             Arrays.fill(row, -1);

//         return solve(triangle, dp, 0, 0, n);
        
//     }
// }

class Solution {

    public int solve(List<List<Integer>> triangle, Integer[][] dp, int i, int j) {

        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int down = solve(triangle, dp, i + 1, j);
        int diagonal = solve(triangle, dp, i + 1, j + 1);

        return dp[i][j] = triangle.get(i).get(j) + Math.min(down, diagonal);
    }

    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();

        Integer[][] dp = new Integer[n][n];

        return solve(triangle, dp, 0, 0);
    }
}