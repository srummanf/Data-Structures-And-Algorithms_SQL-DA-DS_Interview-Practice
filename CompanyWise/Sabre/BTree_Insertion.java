// Asked in Mock

/** Write a program using a B- Tree data structure to store data from a sensor network. Each sensor node produces data points, and you want to insert and traverse the B-Tree using an in-order traversal and print the values in the correct order.
Input format :

The first line of input consists of an integer N, representing the number of data points to be inserted into the B tree.

The second line of input consists of N space-separated elements, representing the data points to be inserted into the tree.
Output format :

The output prints space-separated integers, representing the B- Tree values in the order specified by the traversal method (Inorder traversal).


Refer to the sample output for the formatting specifications.
Code constraints :

1 ≤ N ≤ 20

1 ≤ data points ≤ 100
Sample test cases :
Input 1 :

5
12 8 4 18 6

Output 1 :

4 6 8 12 18 

Input 2 :

8
2 3 10 8 6 4 7 19

Output 2 :

2 3 4 6 7 8 10 19  */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class BTree {
    private int T;
    private Node root;

    static class Node {
        int n;
        ArrayList<Integer> keys = new ArrayList<>();
        ArrayList<Node> children = new ArrayList<>();
        boolean isLeaf;

        Node(int t, boolean leaf) {
            this.isLeaf = leaf;
        }
    }

    BTree(int t) {
        this.T = t;
        root = new Node(t, true);
    }

    public void insert(int key) {
        Node r = root;
        if (r.keys.size() == 2 * T - 1) {
            Node s = new Node(T, false);
            root = s;
            s.children.add(r);
            split(s, 0);
            insertNonFull(s, key);
        } else {
            insertNonFull(r, key);
        }
    }

    private void split(Node x, int i) {
        int t = T;
        Node y = x.children.get(i);
        Node z = new Node(t, y.isLeaf);
        for (int j = 0; j < t - 1; j++) {
            z.keys.add(y.keys.remove(t));
        }
        if (!y.isLeaf) {
            for (int j = 0; j < t; j++) {
                z.children.add(y.children.remove(t));
            }
        }
        x.children.add(i + 1, z);
        x.keys.add(i, y.keys.remove(t - 1));
    }

    private void insertNonFull(Node x, int key) {
        int i = x.keys.size() - 1;
        if (x.isLeaf) {
            x.keys.add(0);
            while (i >= 0 && key < x.keys.get(i)) {
                x.keys.set(i + 1, x.keys.get(i));
                i--;
            }
            x.keys.set(i + 1, key);
        } else {
            while (i >= 0 && key < x.keys.get(i)) {
                i--;
            }
            i++;
            if (x.children.get(i).keys.size() == 2 * T - 1) {
                split(x, i);
                if (key > x.keys.get(i)) {
                    i++;
                }
            }
            insertNonFull(x.children.get(i), key);
        }
    }

    public void inorderTraversal() {
        inorderTraversal(root);
    }

    private void inorderTraversal(Node x) {
        int i;
        for (i = 0; i < x.keys.size(); i++) {
            if (!x.isLeaf) {
                inorderTraversal(x.children.get(i));
            }
            System.out.print(x.keys.get(i) + " ");
        }
        if (!x.isLeaf) {
            inorderTraversal(x.children.get(i));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        BTree btree = new BTree(2); // Minimum degree T = 2 for a simple B-Tree
        for (int i = 0; i < N; i++) {
            int dataPoint = scanner.nextInt();
            btree.insert(dataPoint);
        }
        btree.inorderTraversal();
    }
}
