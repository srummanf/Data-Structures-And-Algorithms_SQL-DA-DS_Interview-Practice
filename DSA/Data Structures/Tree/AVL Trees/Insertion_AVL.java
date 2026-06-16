import java.util.*;

class Insertion_AVL {

  class Node {

    int data, height;
    Node left, right;

    public Node(int data) {
      this.data = data;
      height = 1;
      left = null;
      right = null;
    }
  }

  // Insert node into the AVL Tree
  Node insert(Node node, int data) {
    if (node == null) return new Node(data);

    if (data < node.data) {
      node.left = insert(node.left, data);
    } else if (data > node.data) {
      node.right = insert(node.right, data);
    } else {
      return node; // Duplicate keys are not allowed
    }

    // Update height of the current node
    node.height = Math.max(height(node.left), height(node.right)) + 1;

    // Get balance factor of this node to check if it's unbalanced
    int balance = getBalance(node);

    // Left Left Case
    if (balance > 1 && data < node.left.data) return rightRotate(node);

    // Right Right Case
    if (balance < -1 && data > node.right.data) return leftRotate(node);

    // Left Right Case
    if (balance > 1 && data > node.left.data) {
      node.left = leftRotate(node.left);
      return rightRotate(node);
    }

    // Right Left Case
    if (balance < -1 && data < node.right.data) {
      node.right = rightRotate(node.right);
      return leftRotate(node);
    }

    return node;
  }

  // Get height of a node
  int height(Node node) {
    if (node == null) return 0;
    return node.height;
  }

  // Get the balance factor of a node
  int getBalance(Node node) {
    if (node == null) return 0;
    return height(node.left) - height(node.right);
  }

  // Right Rotation
  Node rightRotate(Node y) {
    Node x = y.left;
    Node T2 = x.right;

    // Perform rotation
    x.right = y;
    y.left = T2;

    // Update heights
    y.height = Math.max(height(y.left), height(y.right)) + 1;
    x.height = Math.max(height(x.left), height(x.right)) + 1;

    // Return new root
    return x;
  }

  // Left Rotation
  Node leftRotate(Node x) {
    Node y = x.right;
    Node T2 = y.left;

    // Perform rotation
    y.left = x;
    x.right = T2;

    // Update heights
    x.height = Math.max(height(x.left), height(x.right)) + 1;
    y.height = Math.max(height(y.left), height(y.right)) + 1;

    // Return new root
    return y;
  }

  // In-order Traversal (Sorted order)
  public void inOrderTraversal(Node node) {
    if (node != null) {
      inOrderTraversal(node.left);
      System.out.print(node.data + " ");
      inOrderTraversal(node.right);
    }
  }

  public static void main(String[] args) {
    // Create an instance of the AVL tree class
    Insertion_AVL tree = new Insertion_AVL();
    Node root = null;

    // Insert nodes into the AVL tree
    root = tree.insert(root, 10);
    root = tree.insert(root, 40);
    root = tree.insert(root, 20);
    root = tree.insert(root, 50);
    root = tree.insert(root, 30);
    root = tree.insert(root, 25);

    // Perform in-order traversal
    System.out.print("In-order traversal of the AVL tree: ");
    tree.inOrderTraversal(root);
  }
}
