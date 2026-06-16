class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return convertListToBST(head, null);
    }

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
}
