class Node {
    int val;
    Node frw; // Forward pointer
    Node bck; // Backward pointer

    Node(int x) {
        val = x;
        frw = null;
        bck = null;
    }
}

public class DoublyLinkedList {
    private Node head;

    // Insert a new node at the end of the list
    public void insert(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.frw != null) {
                current = current.frw;
            }
            current.frw = newNode;
            newNode.bck = current;
        }
    }

    // Search for a value in the list
    public boolean search(int value) {
        Node current = head;
        while (current != null) {
            if (current.val == value) {
                return true;
            }
            current = current.frw;
        }
        return false;
    }

    // Delete a node by value
    public void deleteByValue(int value) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node current = head;
        // Traverse to find the node with the given value
        while (current != null) {
            if (current.val == value) {
                if (current.bck != null) {
                    current.bck.frw = current.frw;
                } else {
                    head = current.frw; // Node to delete is the head
                }
                if (current.frw != null) {
                    current.frw.bck = current.bck;
                }
                return;
            }
            current = current.frw;
        }
        System.out.println("Value not found in the list.");
    }

    // Display all the values in the list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.frw;
        }
        System.out.println();
    }

    // Display the list in reverse order
    public void displayReverse() {
        Node current = head;
        // Traverse to the end of the list
        while (current != null && current.frw != null) {
            current = current.frw;
        }
        // Traverse backward
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.bck;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // Insert values into the doubly linked list
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);

        System.out.print("Original doubly linked list: ");
        list.display();

        // Display the list in reverse order
        System.out.print("Doubly linked list in reverse order: ");
        list.displayReverse();

        // Search for a value
        System.out.println("Search for 3: " + list.search(3));
        System.out.println("Search for 5: " + list.search(5));

        // Delete value 3
        list.deleteByValue(3);
        System.out.print("Doubly linked list after deleting 3: ");
        list.display();

        // Display the list in reverse order
        System.out.print("Doubly linked list in reverse order: ");
        list.displayReverse();
    }
}
