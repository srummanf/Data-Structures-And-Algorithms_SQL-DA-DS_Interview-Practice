/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMiddle(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        left = sortList(left);
        right = sortList(right);

        return merge(left, right);
    }

    private ListNode getMiddle(ListNode head) {
        if (head == null) return head;

        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }

        return dummy.next;
    }
}
// class Solution {
//     public ListNode insert(ListNode head, int val){
//         if(head==null) return new ListNode(val);
//         ListNode temp = head;
//         ListNode newNode = new ListNode(val);
//         while(temp.next!=null){
//             temp = temp.next;
//         }
//         temp.next= newNode;
//         return head;
//     }
//     public void traversal(LinkedList<Integer> ll, ListNode head){
//         ListNode temp = head;
//         while(temp!=null){
//             ll.add(temp.val);
//             temp =  temp.next;
//         }
//     }
//     public ListNode sortList(ListNode head) {
//         ListNode temp = head;
//         LinkedList<Integer> ll = new LinkedList<>();
//         traversal(ll, temp);
//         Collections.sort(ll);
//         ListNode head2 = new ListNode();
//         for(int i : ll){
//             insert(head2, i);
//         }
//         return head2.next;
//     }
// }