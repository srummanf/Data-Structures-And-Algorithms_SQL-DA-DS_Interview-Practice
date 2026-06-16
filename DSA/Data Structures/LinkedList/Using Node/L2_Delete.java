class Node {

  int val;
  Node next;

  Node(int x) {
    val = x;
    next = null;
  }
}

public class L2_Delete {

  Node head;

  void insert(int val) {
    Node new_node = new Node(val);
    if (head == null) {
      head = new_node;
      return;
    }
    Node temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = new_node;
  }

  void delete(int val) {
    if (head.val == val) {
      head = head.next;
      return;
    }

    Node temp = head;
    while (temp.next != null && temp.next.val != val) {
      temp = temp.next;
    }
    // If the node was not found
    if (temp.next == null) {
      System.out.println("Value not found in the list.");
      return;
    }

    temp.next = temp.next.next;
  }

  public void display() {
    Node current = head;
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
  }

  public static void main(String[] args) {
    L2_Delete l1 = new L2_Delete();
    l1.insert(1);
    l1.insert(2);
    l1.insert(3);
    l1.insert(4);
    l1.insert(5);

    l1.delete(1);

    l1.display();
  }
}
