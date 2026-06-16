/*
    MY YOUTUBE VIDEO ON THIS Qn : https://www.youtube.com/watch?v=HXdCemhtrNA
    Company Tags                : Paytm, Zoho, Morgan Stanley, Accolite, Amazon, Microsoft, Snapdeal, D-E-Shaw, MakeMyTrip, Oracle, MAQ Software, nearbuy, Nagarro, BrowserStack
    Frequency                   : 64%
    Leetcode Qn Link            : https://leetcode.com/problems/spiral-matrix-ii/
*/
/** You are given two integers m and n, which represent the dimensions of a matrix.

You are also given the head of a linked list of integers.

Generate an m x n matrix that contains the integers in the linked list presented in spiral order (clockwise), starting from the top-left of the matrix. If there are remaining empty spaces, fill them with -1.

Return the generated matrix.

 

Example 1:


Input: m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0]
Output: [[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]
Explanation: The diagram above shows how the values are printed in the matrix.
Note that the remaining spaces in the matrix are filled with -1. */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

  public int[][] spiralMatrix(int m, int n, ListNode head) {
    if (head == null) return new int[][] { {} };

    int matrix[][] = new int[m][n];
    for (int[] row : matrix) {
      Arrays.fill(row, -1);
    }
    int id = 0;
    // id
    // 0 -> left to right
    // 1 -> top to down
    // 2 -> right to left
    // 3 -> down to top
    int top = 0;
    int down = m - 1;
    int left = 0;
    int right = n - 1;

    while (top <= down && left <= right && head != null) {
      if (id == 0) { // left to right
        for (int i = left; i <= right && head != null; i++) {
          matrix[top][i] = head.val;
          head = head.next;
        }
        top++;
      } else if (id == 1) { // top to down
        for (int i = top; i <= down && head != null; i++) {
          matrix[i][right] = head.val;
          head = head.next;
        }
        right--;
      } else if (id == 2) { // right to left
        for (int i = right; i >= left && head != null; i--) {
          matrix[down][i] = head.val;
          head = head.next;
        }
        down--;
      } else if (id == 3) { // down to top
        for (int i = down; i >= top && head != null; i--) {
          matrix[i][left] = head.val;
          head = head.next;
        }
        left++;
      }

      id = (id + 1) % 4; // Cycle through directions
    }

    return matrix;
  }
}
