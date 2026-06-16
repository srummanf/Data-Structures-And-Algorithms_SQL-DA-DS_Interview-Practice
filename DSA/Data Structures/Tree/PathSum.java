/** Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum. */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    // Helper method to recursively explore all paths
    public boolean f(TreeNode root, int targetSum) {
        if (root == null) {
            return false; // base case: if node is null, return
        }

        // Check if the current node is a leaf and the remaining targetSum is 0
        if (root.left == null && root.right == null && targetSum == root.val) {
            // ans.add(new ArrayList<>(temp)); // add a copy of the current path to the
            // result
            return true;
        }

        // Explore the left and right subtrees
        return f(root.left, targetSum - root.val) || f(root.right, targetSum - root.val);

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {

        return f(root, targetSum);
        
    }
}
