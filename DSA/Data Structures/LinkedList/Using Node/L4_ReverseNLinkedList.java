/** 92. Reverse Linked List II
Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]
 

Constraints:

The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n
  */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insert(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return head;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = null;
        return head;
    }

    public ListNode reverseBetween(ListNode head, int l, int r) {
        LinkedList<Integer> ll = new LinkedList<>();
        ArrayList<Integer> rev = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            ll.add(temp.val);
            temp = temp.next;
        }
        ListNode dummyHead = new ListNode(); // Dummy node to simplify list creation
        ListNode temp2 = dummyHead;
        int n = ll.size();
        for (int i = 0; i < n; i++) {
            if ((i >= l - 1) && (i <= r - 1)) {
                rev.add(ll.get(i));
            }
        }
        Collections.reverse(rev);
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (i < l - 1) {
                insert(temp2, ll.get(i));
            } else if ((i >= l - 1) && (i <= r - 1)) {
                insert(temp2, rev.get(idx++));
            } else {
                insert(temp2, ll.get(i));
            }
        }

        return temp2.next;

    }
}