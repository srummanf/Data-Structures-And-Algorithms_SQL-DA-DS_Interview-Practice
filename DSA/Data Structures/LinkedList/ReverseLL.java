import java.util.*;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class ReverseLL {
    public static Node insert(Node head, int data){
        if(head==null){
            return new Node(data);
        }
        else{
            Node temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = new Node(data);
            return head;
        }
    }

    public static Node reverse(Node head){
        Node current = head;
        Node prev = null;
        Node next = null;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void printlist(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print("NULL");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Node head = null;
        System.out.print("Enter the number of elements in the linked list: ");
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.print("Enter the element: ");
            int data = sc.nextInt();
            head = insert(head, data);
        }
        head = reverse(head);
        printlist(head);
    }
}
