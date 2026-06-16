import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class MaxTreeLengthandBuildTree {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private int maxLength;

    public int longestUnivaluePath(TreeNode root) {
        maxLength = 0;
        helper(root);
        return maxLength;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftPath = helper(node.left);
        int rightPath = helper(node.right);

        int left = 0, right = 0;

        if (node.left != null && node.left.val == node.val) {
            left = leftPath + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            right = rightPath + 1;
        }

        maxLength = Math.max(maxLength, left + right);

        return Math.max(left, right);
    }

    public static TreeNode buildTree(int[] nodes) {
        if (nodes.length == 0 || nodes[0] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (i < nodes.length) {
            TreeNode current = queue.poll();

            if (i < nodes.length && nodes[i] != -1) {
                current.left = new TreeNode(nodes[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < nodes.length && nodes[i] != -1) {
                current.right = new TreeNode(nodes[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        // Split the string by spaces and convert to integer array
        String[] strArray = input.split(" ");
        int[] intArray = new int[strArray.length];

        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }

        // Build the tree using the integer array
        TreeNode root = buildTree(intArray);

        MaxTreeLengthandBuildTree solution = new MaxTreeLengthandBuildTree();
        System.out.println(solution.longestUnivaluePath(root));
    
}
