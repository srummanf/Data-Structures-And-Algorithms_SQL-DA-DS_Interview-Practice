
/**
 * Right view:
 * The Right View offers a view of the nodes seen from the right side of the
 * tree.
 * It includes the rightmost node at each level.
 * Example:
 * 
 *    A
 *   / \
 *  B   C
 * / \ / \
 * D E F G
 * 
 * Right View: A C G
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

public class RightViewOfTree {

    public static List<Character> rightView(TreeNode root) {
        List<Character> rightView = new ArrayList<>();
        if (root == null) {
            return rightView;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (i == levelSize - 1) {

                    rightView.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {

                    queue.offer(node.right);
                }
            }
        }
        return rightView;
    }

    public static void rightViewRecursive(TreeNode curr, int currdepth, ArrayList<Character> ans) {
        if (curr == null)
            return;

        if (currdepth == ans.size()) {
            ans.add(curr.val);
        }
        rightViewRecursive(curr.right, currdepth + 1, ans);
        rightViewRecursive(curr.left, currdepth + 1, ans);
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

        ArrayList<Character> rightViewResultRecursive = new ArrayList<Character>();
        rightViewRecursive(root, 0, rightViewResultRecursive);
        System.out.println(rightViewResultRecursive);

        List<Character> rightViewResult = rightView(root);
        // Printing the Right View
        System.out.print("Right View: ");
        for (char node : rightViewResult) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}

// f(node, level){
// if(node==null) return;

// if(level==ds.size){
// ds.add(node);
// }
// f(node.right, level+1);
// f(node.left, level+1);
// }
