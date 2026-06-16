package LinkedList;
import java.util.*;

class recursiveTraversalOfLinkedList
{
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    Node traversal(Node n){
        if(n == null){
            return null;
        }
        System.out.print(n.data + " ");
        return traversal(n.next);
    }

    public static void main(String[] args)
    {
        Node head = new Node(10);
        Node first = new Node(20);
        Node second = new Node(30);
        Node third = new Node(40);
        Node fourth = new Node(50);

        head.next = first;
        first.next = second;
        second.next = third;
        third.next = fourth;

        recursiveTraversalOfLinkedList r = new recursiveTraversalOfLinkedList();
        r.traversal(head);
    }
}