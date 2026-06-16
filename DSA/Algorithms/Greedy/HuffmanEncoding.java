/** Given a string S of distinct character of size N and their corresponding frequency f[ ] i.e. character S[i] has f[i] frequency. Your task is to build the Huffman tree print all the huffman codes in preorder traversal of the tree.
Note: While merging if two nodes have the same value, then the node which occurs at first will be taken on the left of Binary Tree and the other one to the right, otherwise Node with less value will be taken on the left of the subtree and other one to the right.

Example 1:

S = "abcdef"
f[] = {5, 9, 12, 13, 16, 45}
Output: 
0 100 101 1100 1101 111 */

import java.util.*;

class Solution {
    class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public void traversal(ArrayList<String> ans, Node temp, String t) {
        if (temp.left == null && temp.right == null) {
            ans.add(t);
            return;
        }
        traversal(ans, temp.left, t + "0");
        traversal(ans, temp.right, t + "1");
    }

    public ArrayList<String> huffmanCodes(String S, int f[], int N) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.data, b.data));
        
        for (int i : f) {
            Node temp = new Node(i);
            pq.offer(temp);
        }

        while (pq.size() > 1) {
            Node l = pq.poll();
            Node r = pq.poll();
            Node temp = new Node(l.data + r.data);
            temp.left = l;
            temp.right = r;
            pq.offer(temp);  // add back to the priority queue
        }

        Node root = pq.poll();  // Final node should be the root of the Huffman tree

        ArrayList<String> ans = new ArrayList<>();
        traversal(ans, root, "");
        return ans;
    }
}
