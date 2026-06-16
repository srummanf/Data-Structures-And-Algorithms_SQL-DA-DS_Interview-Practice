/** You are given an array books where books[i] = [thickness_i, height_i] indicates the thickness and height of the ith book. You are also given an integer shelfWidth.

We want to place these books in order onto bookcase shelves that have a total width shelfWidth.

We choose some of the books to place on this shelf such that the sum of their thickness is less than or equal to shelfWidth, then build another level of the shelf of the bookcase so that the total height of the bookcase has increased by the maximum height of the books we just put down. We repeat this process until there are no more books to place.

Note that at each step of the above process, the order of the books we place is the same order as the given sequence of books.

For example, if we have an ordered list of 5 books, we might place the first and second book onto the first shelf, the third book on the second shelf, and the fourth and fifth book on the last shelf.
Return the minimum possible height that the total bookshelf can be after placing shelves in this manner.

 

Example 1:


Input: books = [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]], shelfWidth = 4
Output: 6
Explanation:
The sum of the heights of the 3 shelves is 1 + 3 + 2 = 6.
Notice that book number 2 does not have to be on the first shelf.
Example 2:

Input: books = [[1,3],[2,4],[3,2]], shelfWidth = 6
Output: 4
  */


 class Solution {
    public int f(int idx, int remaining_width, int currentHeight, int[][] books, int shelfWidth, int[][] dp) {
        if (idx >= books.length)
            return currentHeight;

        int thickness = books[idx][0];
        int height = books[idx][1];

        if (dp[idx][remaining_width] != -1)
            return dp[idx][remaining_width];
        int take = Integer.MAX_VALUE;
        if (thickness <= remaining_width) {
            take = f(idx + 1, remaining_width - thickness, Math.max(currentHeight, height), books, shelfWidth, dp);
        }
        int nottake = currentHeight + f(idx + 1, shelfWidth - thickness, height, books, shelfWidth, dp);

        return dp[idx][remaining_width] = Math.min(take, nottake);
    }

    public int minHeightShelves(int[][] books, int shelfWidth) {
        // dp[idx][remaining_width] -> we are looking only in idx and width so dont take thickness or height
        int[][] dp = new int[1001][10001];
        for (int[] a : dp)
            Arrays.fill(a, -1);
        return f(0, shelfWidth, 0, books, shelfWidth, dp);
    }
}
