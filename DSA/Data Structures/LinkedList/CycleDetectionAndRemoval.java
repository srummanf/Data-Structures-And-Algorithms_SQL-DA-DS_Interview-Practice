// https://leetcode.com/problems/linked-list-cycle/

/**
 * Definition for singly-linked list.
 * static class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class CycleLL {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    public void hasCycleAndRemoveCycle(ListNode head) {
        if(head==null || head.next==null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast){
                break;
            }
        }
        if(fast!=slow) return;

        slow = head;
        while(slow.next!=fast.next){
            slow = slow.next;
            fast.next = slow;
        }
        fast.next = null;
    }
}