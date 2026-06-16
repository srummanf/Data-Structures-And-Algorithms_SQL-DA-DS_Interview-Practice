import java.util.Scanner;

class ListNode {

  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}

public class L1_Traversal_Search_Display {

  private ListNode head;

  public void insert(int value) {
    ListNode newNode = new ListNode(value);
    if (head == null) {
      head = newNode;
    } else {
      ListNode current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = newNode;
    }
  }

  public boolean search(int value) {
    ListNode newNode = new ListNode(value);
    if (head == null) {
      return false;
    } else {
      ListNode current = head;
      while (current != null) {
        if (current.val == value) return true;
        current = current.next;
      }
      current.next = newNode;
    }
    return false;
  }

  public void display() {
    int ctr = 0;
    ListNode current = head;
    while (current != null) {
      System.out.print(current.val + " ");
      ctr++;
      current = current.next;
    }
    System.out.print("\nLength of the given Linked List is " + ctr);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    L1_Traversal_Search_Display list = new L1_Traversal_Search_Display();

    System.out.print("Enter the size of the linked list: ");
    int n = scanner.nextInt();

    System.out.println("Enter the numbers:");
    for (int i = 0; i < n; i++) {
      int value = scanner.nextInt();
      list.insert(value);
    }

    System.out.print("The linked list is: ");
    list.display();
    System.out.print("\n");

    System.out.print("Enter the value to be searched in the linked list: ");
    int valsearch = scanner.nextInt();
    System.out.print(list.search(valsearch));
  }
}
