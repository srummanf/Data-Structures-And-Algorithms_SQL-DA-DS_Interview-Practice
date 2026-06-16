/** Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children */


import java.util.ArrayList;
import java.util.List;

class Solution {

    // Helper method to recursively explore all paths
    public void f(TreeNode root, int targetSum, List<Integer> temp, List<List<Integer>> ans) {
        if (root == null) {
            return;  // base case: if node is null, return
        }

        // Add current node's value to the path
        temp.add(root.val);

        // Check if the current node is a leaf and the remaining targetSum is 0
        if (root.left == null && root.right == null && targetSum == root.val) {
            ans.add(new ArrayList<>(temp)); // add a copy of the current path to the result
        }

        // Explore the left and right subtrees
        f(root.left, targetSum - root.val, temp, ans);
        f(root.right, targetSum - root.val, temp, ans);

        // Backtrack by removing the last added node
        temp.remove(temp.size() - 1);
    }

    // Main function to initiate path search
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        f(root, targetSum, temp, ans); // call the recursive function
        return ans;
    }
}

// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  * int val;
//  * TreeNode left;
//  * TreeNode right;
//  * TreeNode() {}
//  * TreeNode(int val) { this.val = val; }
//  * TreeNode(int val, TreeNode left, TreeNode right) {
//  * this.val = val;
//  * this.left = left;
//  * this.right = right;
//  * }
//  * }
//  */
// class Solution {
//     public List<List<Integer>> f(TreeNode root, int targetSum, List<Integer> temp, List<List<Integer>> ans) {
//         if (targetSum == 0) {
//             ans.add(temp);
//         }
//         if (root == null)
//             return;

//         temp.add(root.val);
//         f(root.left, targetSum - root.val, temp, ans);
//         f(root.right, targetSum - root.val, temp, ans);
//         temp.remove(temp.size() - 1);

//         return ans;

//     }

//     public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//         List<List<Integer>> ans = new ArrayList<>();
//         List<Integer> temp = new ArrayList<>();
//         return f(root, targetSum, temp, ans); 
//     }
// }