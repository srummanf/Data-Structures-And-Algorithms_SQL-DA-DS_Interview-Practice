/** Stack<Node, num>
 * 
 * if num == 1
 *          preorder
 *          num++;
 *          go to left(if exist) --> st.add({val, 1})
 * if num == 2
 *          inorder
 *          num++;
 *          go to right(if exist) --> st.add({val, 1})
 * if num == 3
 *          postorder
 *          
 * 
 */

import java.util.*;

class Node {

  int data;
  Node left, right;

  Node(int val) {
    data = val;
    left = null;
    right = null;
  }
}

public class L13_PreInPostOrderTraversalTogetherII {

  static class State {
    Node node;
    int state; // 1: pre, 2: in, 3: post

    State(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static List<List<Integer>> preInPostTraversal(Node root) {
    List<Integer> pre = new ArrayList<>();
    List<Integer> in = new ArrayList<>();
    List<Integer> post = new ArrayList<>();

    if (root == null) {
      return new ArrayList<>();
    }

    Stack<State> st = new Stack<>();
    st.push(new State(root, 1));

    while (!st.isEmpty()) {
      State curr = st.pop();

      switch (curr.state) {
        case 1: // Preorder
          pre.add(curr.node.data);
          st.push(new State(curr.node, 2));
          if (curr.node.left != null) {
            st.push(new State(curr.node.left, 1));
          }
          break;
        case 2: // Inorder
          in.add(curr.node.data);
          st.push(new State(curr.node, 3));
          if (curr.node.right != null) {
            st.push(new State(curr.node.right, 1));
          }
          break;
        case 3: // Postorder
          post.add(curr.node.data);
          break;
      }
    }

    List<List<Integer>> result = new ArrayList<>();
    result.add(pre);
    result.add(in);
    result.add(post);
    return result;
  }

  public static void printList(List<Integer> list) {
    for (int num : list) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);

    List<List<Integer>> traversals = preInPostTraversal(root);

    System.out.print("Preorder traversal: ");
    printList(traversals.get(0));

    System.out.print("Inorder traversal: ");
    printList(traversals.get(1));

    System.out.print("Postorder traversal: ");
    printList(traversals.get(2));
  }
}
