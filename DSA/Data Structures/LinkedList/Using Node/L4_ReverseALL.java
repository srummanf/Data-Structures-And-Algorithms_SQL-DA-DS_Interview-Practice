import java.util.*;

class ListNode {

  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

class Solution {

  // Insert a new node with value `val` at the end of the list
  public ListNode insert(ListNode head, int val) {
    ListNode newNode = new ListNode(val);
    if (head == null) {
      return newNode;
    }
    ListNode current = head;
    while (current.next != null) {
      current = current.next;
    }
    current.next = newNode;
    return head;
  }

  // Reverse the linked list
  public ListNode reverseList(ListNode head) {
    LinkedList<Integer> ll = new LinkedList<>();
    ListNode temp = head;

    // Traverse the list and add values to the linked list
    while (temp != null) {
      ll.add(temp.val);
      temp = temp.next;
    }

    // Reverse the linked list
    Collections.reverse(ll);

    // Create a new list from reversed values
    ListNode dummyHead = new ListNode(0); // Dummy node to simplify list creation
    ListNode newHead = dummyHead;
    for (int value : ll) {
      newHead.next = new ListNode(value);
      newHead = newHead.next;
    }

    return dummyHead.next; // Return the actual head of the reversed list
  }
}



// ---------------------------   Solution 2    -------------------------------
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
}