import java.util.*;

public class FloydDetectionAlgo {
    static class Node {
        int data;
        Node next;
    }

    // Function to detect a loop in the linked list
    static boolean detectLoop(Node head) {
        Node slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true; // Loop detected
            }
        }
        return false; // No loop found
    }

    public static void main(String[] args) {
        Node head = new Node();  // Initialize the linked list
        // Add elements to the linked list
        head.data = 1;
        head.next = new Node();
        head.next.data = 2;
        head.next.next = new Node();
        head.next.next.data = 3;
        head.next.next.next = new Node();
        head.next.next.next.data = 4;

        // Create a loop
        head.next.next.next.next = head;  // This creates a loop

        if (detectLoop(head)) {
            System.out.println("Loop exists in the Linked List");
        } else {
            System.out.println("Loop does not exist in the Linked List");
        }
    }

}
