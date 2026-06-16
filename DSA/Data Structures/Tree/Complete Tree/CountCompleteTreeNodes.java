/** Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity. */

// // Usign the property of Perfect Binary Tree : if tree height is h , then nodes are 2^h-1;

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
//     public int getLeftHeight(TreeNode root) {
//         if (root == null)
//             return 0;
//         return 1 + getLeftHeight(root.left);
//     }

//     public int getRightHeight(TreeNode root) {
//         if (root == null)
//             return 0;
//         return 1 + getRightHeight(root.right);
//     }

//     public int countNodes(TreeNode root) {
//         if (root == null)
//             return 0;
//         int lh = getLeftHeight(root.left);
//         int rh = getRightHeight(root.right);
//         if (lh == rh)
//             return (int) Math.pow(2, lh) - 1;

//         return countNodes(root.left) + countNodes(root.right) + 1;
//     }
// }
class Solution {
    // Helper function to get the height of the leftmost path
    public int getLeftHeight(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + getLeftHeight(root.left);
    }

    // Helper function to get the height of the rightmost path
    public int getRightHeight(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + getRightHeight(root.right);
    }

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        // Get heights of the leftmost and rightmost paths
        int lh = getLeftHeight(root);
        int rh = getRightHeight(root);

        // If heights are equal, it's a perfect binary tree
        if (lh == rh)
            return (int) Math.pow(2, lh) - 1;

        // Otherwise, recursively count nodes in left and right subtrees
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
