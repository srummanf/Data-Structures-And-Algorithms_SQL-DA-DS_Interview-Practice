// Given the root of a binary tree, determine if it is a complete binary tree.

// In a complete binary tree, every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

 

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

//     public boolean isCompleteTree(TreeNode root) {
//         if (root == null)
//             return true;
//         if (root.left == null && root.right != null)
//             return false;
//         // Important case
//         if (root.left != null && root.right == null)
//             return isCompleteTree(root.left);
//         int lh = getLeftHeight(root);
//         int rh = getRightHeight(root);
//         if (lh - rh > 1)
//             return false;
//         return isCompleteTree(root.left) && isCompleteTree(root.right);
//     }
// }

// Level Order Traversal

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null)
            return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean end = false; // flag to mark if we have encountered a non-full node

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current == null) {
                end = true; // Once we see a null node, all subsequent nodes must be null
            } else {
                if (end) {
                    // If we encounter a non-null node after seeing a null node, it's not complete
                    return false;
                }
                queue.offer(current.left);  // Add left child
                queue.offer(current.right); // Add right child
            }
        }

        return true;
    }
}

