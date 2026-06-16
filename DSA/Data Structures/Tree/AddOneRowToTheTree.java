/** Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth.

Note that the root node is at depth 1.

The adding rule is:

Given the integer depth, for each not null tree node cur at the depth depth - 1, create two tree nodes with value val as cur's left subtree root and right subtree root.
cur's original left subtree should be the left subtree of the new left subtree root.
cur's original right subtree should be the right subtree of the new right subtree root.
If depth == 1 that means there is no depth depth - 1 at all, then create a tree node with value val as the new root of the whole original tree, and the original tree is the new root's left subtree.

 */

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
    public TreeNode addOne(TreeNode root, int val, int depth, int curr) {
        if (root == null)
            return null;
        if (curr == depth - 1) {
            TreeNode l = root.left;
            TreeNode r = root.right;
            root.left = new TreeNode(val);
            root.right = new TreeNode(val);
            root.left.left = l;
            root.right.right = r;
            return root;
        }

        root.left = addOne(root.left, val, depth, curr + 1);
        root.right = addOne(root.right, val, depth, curr + 1);

        return root;

    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newroot = new TreeNode(val);
            newroot.left = root;
            return newroot;
        }
        int curr = 1;
        return addOne(root, val, depth, curr);
    }
}