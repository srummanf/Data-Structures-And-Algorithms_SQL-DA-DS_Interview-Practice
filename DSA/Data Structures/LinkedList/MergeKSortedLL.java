import java.util.PriorityQueue;

import SDOT.LinkedList.MergeKSortedLL;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
 */

public class MergeKSortedLL {

  static class ListNode {
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

  public ListNode mergeKLists(ListNode[] lists) {
    int n = lists.length;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int i = 0; i < n; i++) {
      ListNode head = lists[i];
      while (head != null) {
        pq.offer(head.val);
        head = head.next;
        // System.out.println(pq);
      }
    }

    ListNode head = new ListNode();
    ListNode current = head;
    while (pq.size() >= 1) {
      int a = pq.poll();
      ListNode newNode = new ListNode(a);
      newNode.next = null;
      current.next = newNode;
      current = newNode;
    }
    return head.next;
  }

  public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
  public static void main(String[] args) {
    MergeKSortedLL ob = new MergeKSortedLL();
    int[][] arrays = {{1, 4, 5}, {1, 3, 4}, {2, 6}};
        ListNode[] lists = new ListNode[arrays.length];

        for (int i = 0; i < arrays.length; i++) {
            ListNode dummy = new ListNode();
            ListNode current = dummy;
            for (int num : arrays[i]) {
                current.next = new ListNode(num);
                current = current.next;
            }
            lists[i] = dummy.next;
        }
        ListNode result = ob.mergeKLists(lists);
        ob.printList(result);
  }
}
