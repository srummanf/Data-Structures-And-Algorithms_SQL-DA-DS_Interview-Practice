public class Node {
  int val;
  Node next;

  Node(int x) {
    val = x;
    next = null;
  }
}

public class L2_Insert {

    // Insert at the beginning
    /** */
    public Node insertAtBeginning(Node head, int value) {
      Node newNode = new Node(value);
      newNode.next = head;
      return newNode;
    }

    // Insert at a specific position
    public Node insertAtPosition(Node head, int value, int position) {
      Node newNode = new Node(value);
      if (position == 0) {
        newNode.next = head;
        return newNode;
      }

      Node current = head;
      for (int i = 0; i < position - 1; i++) {
        if (current == null) {
          throw new IllegalArgumentException("Position out of bounds");
        }
        current = current.next;
      }
      newNode.next = current.next;
      current.next = newNode;
      return head;
    }

    // Insert at the end
    public Node insertAtEnd(Node head, int value) {
      Node newNode = new Node(value);
      if (head == null) {
        return newNode;
      }

      Node current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = newNode;
      return head;
    }
  }

  public static void main(String[] args) {
    LinkedListOperations operations = new LinkedListOperations();

    // Create a linked list 1 -> 2 -> 3
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);

    // Insert at beginning
    head = operations.insertAtBeginning(head, 0);

    // Insert at position 2
    head = operations.insertAtPosition(head, 5, 2);

    // Insert at end
    head = operations.insertAtEnd(head, 6);

    // Print the list
    printList(head);
  }

  public static void printList(Node head) {
    Node current = head;
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
    System.out.println();
  }
}
