import java.util.ArrayList;

import javax.swing.tree.TreeNode;

public class Learn {
int sumRange = 0;
  static class Node {

    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  public static Node insert(Node root, int val) {
    if (root == null) {
      root = new Node(val);
      return root;
    }
    if (val < root.data) {
      root.left = insert(root.left, val);
    } else {
      root.right = insert(root.right, val);
    }
    return root;
  }

  public static void inorder(Node root) {
    if (root == null) return;
    inorder(root.left);
    System.out.print(root.data + " ");
    inorder(root.right);
  }

  // ----------------------------------- SEARCH --------------------------------------------------------------------------

  public static boolean search(Node root, int key) {
    if (root == null) return false;
    if (root.data > key) {
      return search(root.left, key);
    } else if (root.data == key) {
      return true;
    } else {
      return search(root.right, key);
    }
  }

  // ----------------------------------- DELETE NODE --------------------------------------------------------------------------
  
  public static Node delete(Node root, int val) {
    if (root.data > val) {
      root.left = delete(root.left, val);
    } else if (root.data < val) {
      root.right = delete(root.right, val);
    } else {
      //root.data == val

      //leaf node
      if (root.left == null && root.right == null) return null;
      //one child
      else if (root.left == null) return root.right; else if (
        root.right == null
      ) return root.left;
      //two child
      else {
        Node IS = inOrderSuccessor(root.right);
        root.data = IS.data;
        root.right = delete(root.right, IS.data);
      }
    }
    return root;
  }

  public static Node inOrderSuccessor(Node root) {
    while (root.left != null) {
      root = root.left;
    }
    return root;
  }

  // ----------------------------------- PRINT IN RANGE (between k1 and k2) : BST : Level Order --------------------------------------------------------------------------

  public static void printInRange(Node root, int k1, int k2) {
    if (root == null) return;
    if (root.data >= k1 && root.data <= k2) {
      printInRange(root.left, k1, k2);
      System.out.print(root.data + " ");
      printInRange(root.right, k1, k2);
    } else if (root.data >= k2) {
      printInRange(root.left, k1, k2);
    } else {
      printInRange(root.right, k1, k2);
    }
  }
  // ----------------------------------- RANGE SUM OF BST --------------------------------------------------------------------------
public int rangeSumBST(Node root, int k1, int k2) {
        if (root == null) return 0;
    if (root.data >= k1 && root.data <= k2) {
        sumRange = sumRange + root.data;
      rangeSumBST(root.left, k1, k2);
      System.out.print(root.data + " ");
      rangeSumBST(root.right, k1, k2);
    } else if (root.data >= k2) {
      rangeSumBST(root.left, k1, k2);
    } else {
      rangeSumBST(root.right, k1, k2);
    }
    return sumRange;
    }

//     class Solution {
//     public int rangeSumBST(TreeNode root, int low, int high) {
//         if (root == null) {
//             return 0;
//         }
//         if (low <= root.val && root.val <= high) {
//             return root.val + rangeSumBST(root.left, low, high)
//                 + rangeSumBST(root.right, low, high);
//         } else if (root.val < low) {
//             return rangeSumBST(root.right, low, high);
//         } else {
//             return rangeSumBST(root.left, low, high);
//         }
//     }
// }


  // ----------------------------------- Root to Leaf Path --------------------------------------------------------------------------

  public static void printRootToLeaf(Node root, ArrayList<Integer> path) {
    if (root == null) return;
    path.add(root.data);
    if (root.left == null && root.right == null) {
      System.out.println(path.toString());
    } else {
      printRootToLeaf(root.left, path);
      printRootToLeaf(root.right, path);
    }
    path.remove(path.size() - 1);
  }

  // --------------------------------------- MAIN Function --------------------------------------------------------------------------

  public static void main(String[] args) {
    int val[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
    Node root = null;
    for (int x :  val) {
      root = insert(root, x);
    }
    inorder(root);
    System.out.println(search(root, 7));

    // root = delete(root, 3);
    // inorder(root);
    // System.out.println();
    // printInRange(root, 3, 10);

    ArrayList<Integer> path = new ArrayList<>();
    printRootToLeaf(root, path);
  }
}
