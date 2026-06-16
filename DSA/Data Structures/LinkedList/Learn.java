import java.util.Scanner;

public class Learn {

  static class LL {

    int val;
    LL next;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Create a dummy node to represent the head of the linked list
    LL head = new LL();

    LL current = head;

    System.out.println("Enter the number of elements for the linked list:");
    int n = scanner.nextInt();

    System.out.println("Enter the elements for the linked list:");

    // Taking input from the user and creating the linked list
    for (int i = 0; i < n; i++) {
      LL newNode = new LL();
      newNode.val = scanner.nextInt();
      newNode.next = null;

      current.next = newNode;
      current = newNode;
    }

    // Skipping the dummy node and printing the linked list
    head = head.next;
    System.out.println("Linked List elements:");

    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }

    // Close the scanner
    scanner.close();
  }
}
