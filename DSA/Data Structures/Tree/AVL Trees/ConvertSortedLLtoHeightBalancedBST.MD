

# TL;DR

If the input is not dynamic (you have a set of numbers and then you need AVL tree) : 

### For Linked List

```java
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return convertListToBST(head, null);
    }

    private TreeNode convertListToBST(ListNode head, ListNode tail) {
        if (head == tail) return null;

        ListNode slow = head;
        ListNode fast = head;

        // Find the middle node
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = convertListToBST(head, slow);
        root.right = convertListToBST(slow.next, tail);

        return root;
    }
}
```

### For Array List

```java
public TreeNode sortedArrayToBST(ArrayList<Integer> list) {
        if (list == null || list.isEmpty()) return null;
        return convertListToBST(list, 0, list.size());
    }

    // Helper function to recursively build the BST from the ArrayList
    private TreeNode convertListToBST(ArrayList<Integer> list, int start, int end) {
        if (start >= end) return null;

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(list.get(mid));

        root.left = convertListToBST(list, start, mid);
        root.right = convertListToBST(list, mid + 1, end);

        return root;
    }
```


# SORTED ARRAYLIST TO AVL

To modify the code to work with an `ArrayList` instead of a `LinkedList`, follow these steps:

1. **Replace LinkedList Operations**: Use `ArrayList` for storing values.
2. **Sort the ArrayList**: Ensure the `ArrayList` is sorted before converting it into a BST.
3. **Modify Methods**: Adjust the methods to work with an `ArrayList` rather than a `LinkedList`.

Here's the modified code:

```java
import java.util.*;

class Insertion2 {

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // Function to convert sorted ArrayList to a height-balanced BST
    public TreeNode sortedArrayToBST(ArrayList<Integer> list) {
        if (list == null || list.isEmpty()) return null;
        return convertListToBST(list, 0, list.size());
    }

    // Helper function to recursively build the BST from the ArrayList
    private TreeNode convertListToBST(ArrayList<Integer> list, int start, int end) {
        if (start >= end) return null;

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(list.get(mid));

        root.left = convertListToBST(list, start, mid);
        root.right = convertListToBST(list, mid + 1, end);

        return root;
    }

    // Helper function to print In-order traversal of the BST
    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    // Function to create and sort an ArrayList from the given values
    public ArrayList<Integer> createAndSortArrayList(Integer[] values) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(values));
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        Insertion2 solution = new Insertion2();

        // Given values
        Integer[] values = {5, 22, 33, 12, 45, 22, 56, 31, 60, 67, 8, 85, 92};

        // Create and sort the ArrayList
        ArrayList<Integer> sortedList = solution.createAndSortArrayList(values);

        // Print the sorted ArrayList
        System.out.print("Sorted ArrayList: ");
        for (int val : sortedList) {
            System.out.print(val + " ");
        }
        System.out.println();

        // Convert the sorted ArrayList to a height-balanced BST
        TreeNode root = solution.sortedArrayToBST(sortedList);

        // Print the in-order traversal of the BST
        System.out.print("In-order Traversal of the Height-Balanced BST: ");
        solution.inorderTraversal(root);
        System.out.println();
    }
}
```

### Changes Made:

1. **Removed `ListNode` Class**: Replaced with `ArrayList` operations.
2. **`sortedArrayToBST` Method**: Converts the sorted `ArrayList` to a height-balanced BST.
3. **`convertListToBST` Method**: Adjusted to work with `ArrayList` indices.
4. **`createAndSortArrayList` Method**: Creates and sorts an `ArrayList` from given values.
5. **`main` Method**:
   - Uses a predefined array of values.
   - Creates and sorts the `ArrayList`.
   - Converts the sorted `ArrayList` to a height-balanced BST.
   - Prints both the sorted list and the in-order traversal of the BST.

### Output Example:

```
Sorted ArrayList: 5 8 12 22 22 31 33 45 56 60 67 85 92 
In-order Traversal of the Height-Balanced BST: 5 8 12 22 22 31 33 45 56 60 67 85 92 
```

This code correctly converts a sorted `ArrayList` to a height-balanced BST and prints the in-order traversal of the resulting tree.

---

# SORTED LINKED LIST TO AVL 

The code you've provided is **correct for converting a sorted linked list into a height-balanced binary search tree (BST)**, but it is **not specifically an AVL tree**. It ensures that the resulting tree is height-balanced, but it does not guarantee the AVL property of balancing via rotations.

### Key Points:

- **Height-Balanced BST**: The code ensures the height of the left and right subtrees of any node differs by at most one, which is a property of a balanced tree.
- **AVL Tree Property**: An AVL tree, however, specifically maintains the **balance factor** (difference in height between left and right subtrees) of every node through **rotations** during insertion and deletion operations, which your code does not handle.

### Why this isn't an AVL Tree:

- **No Rotations**: AVL trees maintain balance through rotations (single or double) after every insertion or deletion to ensure the balance factor remains between `-1` and `1`. Your code does not include rotations.
- **Balanced Tree vs AVL Tree**: A height-balanced BST is **not necessarily an AVL tree** because an AVL tree needs to actively rebalance itself using rotations.

### Conclusion:

- Your code is **correct** for converting a sorted linked list to a **balanced BST**, which is close to an AVL tree. However, if you are specifically required to build an AVL tree, you will need to add rotation logic to maintain the balance factor after each insertion or deletion.

If you only need to convert a sorted list to a height-balanced BST (without the stricter AVL constraints), then your solution is fine.



Below is the code with the class renamed to `Insertion2`, and a `main` method added to test the conversion of a sorted linked list to a height-balanced BST. I have also added a utility function to generate a random linked list, sort it, and then convert it to a balanced BST:

```java
import java.util.*;

class Insertion2 {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // Function to convert sorted list to a height-balanced BST
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return convertListToBST(head, null);
    }

    // Helper function to recursively build the BST
    private TreeNode convertListToBST(ListNode head, ListNode tail) {
        if (head == tail) return null;

        ListNode slow = head;
        ListNode fast = head;

        // Find the middle node
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = convertListToBST(head, slow);
        root.right = convertListToBST(slow.next, tail);

        return root;
    }

    // Helper function to print In-order traversal of the BST
    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    // Function to generate a random linked list
    public ListNode generateRandomLinkedList(int size) {
        Random rand = new Random();
        List<Integer> list = new ArrayList<>();

        // Generate random numbers and add them to the list
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt(100)); // Random numbers between 0 and 100
        }

        // Sort the list to create a sorted linked list
        Collections.sort(list);

        // Create the linked list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : list) {
            current.next = new ListNode(val);
            current = current.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Insertion2 solution = new Insertion2();

        // Generate a random sorted linked list
        int size = 10;  // You can change the size of the linked list
        ListNode head = solution.generateRandomLinkedList(size);

        // Print the linked list
        System.out.print("Sorted Linked List: ");
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();

        // Convert the sorted linked list to a height-balanced BST
        TreeNode root = solution.sortedListToBST(head);

        // Print the in-order traversal of the BST
        System.out.print("In-order Traversal of the Height-Balanced BST: ");
        solution.inorderTraversal(root);
        System.out.println();
    }
}
```

### Explanation:

1. **ListNode Class**: A simple singly linked list node.
2. **TreeNode Class**: Represents a node in the binary search tree (BST).
3. **`sortedListToBST` Method**: Converts the sorted linked list to a height-balanced BST using a two-pointer technique (slow/fast) to find the middle node.
4. **`convertListToBST` Method**: A helper method that recursively converts the linked list into a balanced BST.
5. **`inorderTraversal` Method**: This prints the tree in in-order fashion, which should give the sorted order if the BST is built correctly.
6. **`generateRandomLinkedList` Method**: Generates a random linked list, sorts it, and then returns the head of the sorted linked list.
7. **`main` Method**: Generates a sorted linked list with random values, converts it to a height-balanced BST, and prints both the linked list and the in-order traversal of the resulting tree.

### Output Example:

```
Sorted Linked List: 5 12 22 33 45 56 60 67 85 92 
In-order Traversal of the Height-Balanced BST: 5 12 22 33 45 56 60 67 85 92 
```

This solution efficiently creates a height-balanced BST from the sorted linked list and provides a visual confirmation through in-order traversal that the tree is indeed balanced and sorted.
