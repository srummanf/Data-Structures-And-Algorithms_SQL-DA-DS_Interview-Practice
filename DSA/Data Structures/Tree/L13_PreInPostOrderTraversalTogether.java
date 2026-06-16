import java.util.*;

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

class Node {
    int data;
    Node left, right;
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

public class L13_PreInPostOrderTraversalTogether {

    public static List<List<Integer>> preInPostTraversal(Node root) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        if (root == null) {
            return new ArrayList<>();
        }

        Stack<Pair<Node, Integer>> st = new Stack<>();
        st.push(new Pair<>(root, 1));

        while (!st.empty()) {
            Pair<Node, Integer> it = st.pop();

            if (it.getValue() == 1) {
                pre.add(it.getKey().data);
                it.setValue(2);
                st.push(it);

                if (it.getKey().left != null) {
                    st.push(new Pair<>(it.getKey().left, 1));
                }
            } else if (it.getValue() == 2) {
                in.add(it.getKey().data);
                it.setValue(3);
                st.push(it);

                if (it.getKey().right != null) {
                    st.push(new Pair<>(it.getKey().right, 1));
                }
            } else {
                post.add(it.getKey().data);
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
