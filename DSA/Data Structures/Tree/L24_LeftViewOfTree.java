
/**
 * Left view:
 * The Left View provides a view of the nodes seen from the left side of the
 * tree.
 * It includes the leftmost node at each level.
 * Example:
 * 
 * A
 * / \
 * B C
 * / \ / \
 * D E F G
 * 
 * Left View: A B D
 * 
 */

import java.util.*;

class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;

    public TreeNode(char val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class LeftViewOfTree {

    public static List<Character> leftView(TreeNode root) {
        List<Character> leftView = new ArrayList<>();

        if (root == null) {
            return leftView;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();

        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {

            int levelSize = nodeQueue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = nodeQueue.poll();

                if (i == 0) {
                    leftView.add(node.val);
                }
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                }
                if (node.right != null) {

                    nodeQueue.offer(node.right);
                }
            }
        }
        return leftView;
    }

    public static void leftViewRecursive(TreeNode curr, int currdepth, ArrayList<Character> ans) {
        if (curr == null)
            return;

        if (currdepth == ans.size()) {
            ans.add(curr.val);
        }
        leftViewRecursive(curr.left, currdepth + 1, ans);
        leftViewRecursive(curr.right, currdepth + 1, ans);
    }

    public static void main(String[] args) {
        // Sample binary tree input
        TreeNode root = new TreeNode('A');
        root.left = new TreeNode('B');
        root.right = new TreeNode('C');
        root.left.left = new TreeNode('D');
        root.left.right = new TreeNode('E');
        root.right.left = new TreeNode('F');
        root.right.right = new TreeNode('G');

        ArrayList<Character> leftViewResultRecursive = new ArrayList<Character>();
        leftViewRecursive(root, 0, leftViewResultRecursive);
        System.out.println(leftViewResultRecursive);

        List<Character> leftViewResult = leftView(root);
        // Printing the Left View
        System.out.print("Left View: ");
        for (char node : leftViewResult) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}