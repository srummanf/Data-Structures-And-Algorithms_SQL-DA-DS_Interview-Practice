// OA

/** Given a linked list of integers and a positive integer N. Create a new linked list by reversing every alternate N nodes of the linked list. If the number of nodes in the list or in the last group is less than N, just reverse the remaining nodes.

Example:

linked list:  7 8 9 10 11 12 13 14 15 16
N: 4 

Output: 10 9 8 7 11 12 13 14 16 15
Reverse the first N(4) nodes and then skip the next N(4) nodes. Now, since the number of nodes remaining in the list (2) is less than N,then just reverse the remaining nodes (15 and 16). */

import java.util.LinkedList;
import java.util.ListIterator;

class Node {

  int data;
  Node next;

  Node(int data) {
    this.data = data;
    this.next = null;
  }
}

public class RotateNAlternateNodesinLL {

  public static Node reverseAlternateN(Node head, int N) {
    if (head == null || N <= 1) return head;

    LinkedList<Integer> list = new LinkedList<>();
    Node current = head;
    while (current != null) {
      list.add(current.data);
      current = current.next;
    }

    LinkedList<Integer> result = new LinkedList<>();
    ListIterator<Integer> it = list.listIterator();
    boolean reverse = true;

    while (it.hasNext()) {
      LinkedList<Integer> temp = new LinkedList<>();
      for (int i = 0; i < N && it.hasNext(); i++) {
        temp.add(it.next());
      }
      if (reverse) {
        while (!temp.isEmpty()) {
          result.add(temp.removeLast());
        }
      } else {
        result.addAll(temp);
      }
      reverse = !reverse;
    }

    return convertListToNode(result);
  }

  private static Node convertListToNode(LinkedList<Integer> list) {
    if (list.isEmpty()) return null;
    Node head = new Node(list.removeFirst());
    Node current = head;
    while (!list.isEmpty()) {
      current.next = new Node(list.removeFirst());
      current = current.next;
    }
    return head;
  }

  public static void main(String[] args) {
    // Example linked list: 7 -> 8 -> 9 -> 10 -> 11 -> 12 -> 13 -> 14 -> 15 -> 16
    Node head = new Node(7);
    head.next = new Node(8);
    head.next.next = new Node(9);
    head.next.next.next = new Node(10);
    head.next.next.next.next = new Node(11);
    head.next.next.next.next.next = new Node(12);
    head.next.next.next.next.next.next = new Node(13);
    head.next.next.next.next.next.next.next = new Node(14);
    head.next.next.next.next.next.next.next.next = new Node(15);
    head.next.next.next.next.next.next.next.next.next = new Node(16);

    int N = 4;
    Node result = reverseAlternateN(head, N);
    printList(result); // Expected Output: 10 -> 9 -> 8 -> 7 -> 11 -> 12 -> 13 -> 14 -> 16 -> 15
  }

  private static void printList(Node head) {
    Node current = head;
    while (current != null) {
      System.out.print(current.data);
      if (current.next != null) {
        System.out.print(" -> ");
      }
      current = current.next;
    }
    System.out.println();
  }
}
