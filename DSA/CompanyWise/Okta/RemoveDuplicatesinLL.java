/** Problem Statement


Given the head of a sorted linked list, remove all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list after removing duplicates.


Example 1


Input:

7

1 2 3 3 4 4 5


Output: 

1 2 5 


Example 2


Input:

5

1 1 1 2 3


Output:

2 3 
Input format :

The first line of input consists of an integer n, representing the number of nodes in the linked list.

The second line of input consists of n space-separated integers, denoting the values of the nodes in the linked list.
Output format :

The output prints the values of the nodes in the linked list after removing duplicates and maintaining the sorted order.


Refer to the sample output for the formatting specifications
Code constraints :

1 ≤ n ≤ 20

-100 ≤ Elements of the node ≤ 100

The list is guaranteed to be sorted in ascending order.
Sample test cases :
Input 1 :

7
1 2 3 3 4 4 5

Output 1 :

1 2 5 

Input 2 :

5
1 1 1 2 3

Output 2 :

2 3 
 */


import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println();
            return;
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        for (int i = 0; i < n; i++) {
            tail.next = new ListNode(sc.nextInt());
            tail = tail.next;
        }
        
        ListNode result = deleteDuplicates(dummy.next);
        
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
    
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }
        
        return dummy.next;
    }
}
