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

    public boolean f(TreeNode root, long l, long r) {
        if(root==null ) return true;
        
        if (root.val > l && root.val < r) {
            return f(root.left, l, root.val) && f(root.right, root.val, r);
        } else
            return false;
    }

    public boolean isValidBST(TreeNode root) {
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        return f (root, min, max);
    }
}