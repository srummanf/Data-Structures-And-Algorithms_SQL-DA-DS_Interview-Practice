/** Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

 

Example 1:

Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 2:

Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 3:

Input: matrix = [[7,8],[1,2]]
Output: [7]
Explanation: 7 is the only lucky number since it is the minimum in its row and the maximum in its column.
 
 */

// Cisco, Oracle

class Solution {

    public static <T> ArrayList<T> intersection(HashSet<T> set1, HashSet<T> set2) {
        HashSet<T> resultSet = new HashSet<>(set1);
        resultSet.retainAll(set2);
        return new ArrayList<>(resultSet);
    }


    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int r =  matrix.length;
        int c =  matrix[0].length;
        HashSet<Integer> hash = new HashSet<>();
        HashSet<Integer> hashmax = new HashSet<>();
        
        for(int i = 0; i<r ; i++){
            int mini = Integer.MAX_VALUE;
            for(int j = 0; j<c; j++){
                mini = Math.min(mini, matrix[i][j]);
            }
            hash.add(mini);
        }


        for(int i = 0; i<c ; i++){
            int maxi = Integer.MIN_VALUE;
            for(int j = 0; j<r; j++){
                maxi = Math.max(maxi, matrix[j][i]);
            }
            hashmax.add(maxi);
        }

        System.out.println(hash + "---" + hashmax);

        return intersection(hash, hashmax);
        
        
    }
}