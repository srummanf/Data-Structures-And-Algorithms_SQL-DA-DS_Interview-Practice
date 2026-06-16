/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both trees are empty, they are the same.
        if (p == null && q == null) return true;

        // If one of the trees is empty or the values of current nodes don't match,
        // the trees aren't the same.
        if (p == null || q == null || p.val != q.val) return false;

        // Recursively check if the left subtree of both trees are the same 
        // AND the right subtree of both trees are the same.
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}




// ------------------------------------- HashSet Solution ----------------------------------------------------

import java.util.HashSet;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode() {}

    TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Main {
    public boolean isIdentical(TreeNode p, TreeNode q) {
        HashSet<String> tree1 = new HashSet<>();
        HashSet<String> tree2 = new HashSet<>();
        traverse(p, tree1, "1");
        traverse(q, tree2, "1");
        return tree1.equals(tree2);
    }

    private void traverse(TreeNode node, HashSet<String> set, String path) {
        if (node == null) {
            set.add(path + "null");
            return;
        }
        set.add(path + node.val);
        traverse(node.left, set, path + "L");
        traverse(node.right, set, path + "R");
    }

    public static void main(String[] args) {
        Main solution = new Main();

        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);

        System.out.println(solution.isIdentical(tree1, tree2)); // Output: true

        TreeNode tree3 = new TreeNode(1);
        tree3.left = new TreeNode(2);

        TreeNode tree4 = new TreeNode(1);
        tree4.right = new TreeNode(2);

        System.out.println(solution.isIdentical(tree3, tree4)); // Output: false
    }
}
