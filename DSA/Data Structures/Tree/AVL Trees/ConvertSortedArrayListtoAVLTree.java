import java.util.*;

class ConvertSortedArrayListtoAVLTree {

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // Function to convert sorted ArrayList to a height-balanced BST
    public TreeNode sortedArrayToBST(ArrayList<Integer> list) {
        if (list == null || list.isEmpty()) return null;
        return convertListToBST(list, 0, list.size());
    }

    // Helper function to recursively build the BST from the ArrayList
    private TreeNode convertListToBST(ArrayList<Integer> list, int start, int end) {
        if (start >= end) return null;

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(list.get(mid));

        root.left = convertListToBST(list, start, mid);
        root.right = convertListToBST(list, mid + 1, end);

        return root;
    }

    // Helper function to print In-order traversal of the BST
    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    // Function to create and sort an ArrayList from the given values
    public ArrayList<Integer> createAndSortArrayList(Integer[] values) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(values));
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        ConvertSortedArrayListtoAVLTree solution = new ConvertSortedArrayListtoAVLTree();

        // Given values
        Integer[] values = {5, 22, 33, 12, 45, 22, 56, 31, 60, 67, 8, 85, 92};

        // Create and sort the ArrayList
        ArrayList<Integer> sortedList = solution.createAndSortArrayList(values);

        // Print the sorted ArrayList
        System.out.print("Sorted ArrayList: ");
        for (int val : sortedList) {
            System.out.print(val + " ");
        }
        System.out.println();

        // Convert the sorted ArrayList to a height-balanced BST
        TreeNode root = solution.sortedArrayToBST(sortedList);

        // Print the in-order traversal of the BST
        System.out.print("In-order Traversal of the Height-Balanced BST: ");
        solution.inorderTraversal(root);
        System.out.println();
    }
}
