import java.util.*;

class ConvertSortedLLtoHeightBalancedBST {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

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

    // Function to convert sorted list to a height-balanced BST
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return convertListToBST(head, null);
    }

    // Helper function to recursively build the BST
    private TreeNode convertListToBST(ListNode head, ListNode tail) {
        if (head == tail) return null;

        ListNode slow = head;
        ListNode fast = head;

        // Find the middle node
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = convertListToBST(head, slow);
        root.right = convertListToBST(slow.next, tail);

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

    // Function to generate a random linked list
    public ListNode generateRandomLinkedList(int size) {
        Random rand = new Random();
        List<Integer> list = new ArrayList<>();

        // Generate random numbers and add them to the list
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt(100)); // Random numbers between 0 and 100
        }

        // Sort the list to create a sorted linked list
        Collections.sort(list);

        // Create the linked list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : list) {
            current.next = new ListNode(val);
            current = current.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ConvertSortedLLtoHeightBalancedBST solution = new ConvertSortedLLtoHeightBalancedBST();

        // Generate a random sorted linked list
        int size = 10;  // You can change the size of the linked list
        ListNode head = solution.generateRandomLinkedList(size);

        // Print the linked list
        System.out.print("Sorted Linked List: ");
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();

        // Convert the sorted linked list to a height-balanced BST
        TreeNode root = solution.sortedListToBST(head);

        // Print the in-order traversal of the BST
        System.out.print("In-order Traversal of the Height-Balanced BST: ");
        solution.inorderTraversal(root);
        System.out.println();
    }
}
