public class Trie {

  static class Node {

    Node[] links = new Node[26];
    boolean flag = false;

    boolean containsKey(char ch) {
      return links[ch - 'a'] != null;
    }

    void put(char ch, Node node) {
      links[ch - 'a'] = node;
    }

    Node get(char ch) {
      return links[ch - 'a'];
    }

    void setEnd() {
      flag = true;
    }

    boolean isEnd() {
      return flag;
    }
  }

  Node root;

  Trie() {
    root = new Node();
  }

  public void insert(String word) {
    Node node = root;
    for (int i = 0; i < word.length(); i++) {
      if (!node.containsKey(word.charAt(i))) {
        node.put(word.charAt(i), new Node());
      }
      node = node.get(word.charAt(i));
    }
    node.setEnd();
  }

  public boolean search(String word) {
    Node node = root;
    for (int i = 0; i < word.length(); i++) {
      if (!node.containsKey(word.charAt(i))) {
        return false;
      }
      node = node.get(word.charAt(i));
    }
    return node.isEnd();
  }

  public boolean startsWith(String prefix) {
    Node node = root;
    for (int i = 0; i < prefix.length(); i++) {
      if (!node.containsKey(prefix.charAt(i))) {
        return false;
      }
      node = node.get(prefix.charAt(i));
    }
    return true;
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    System.out.println("Inserting words: Striver, Striving, String, Strike");
    trie.insert("striver");
    trie.insert("striving");
    trie.insert("string");
    trie.insert("strike");

    System.out.println(
      "Search if Strawberry exists in trie: " +
      (trie.search("strawberry") ? "True" : "False")
    );

    System.out.println(
      "Search if Strike exists in trie: " +
      (trie.search("strike") ? "True" : "False")
    );

    System.out.println(
      "If words in Trie start with Stri: " +
      (trie.startsWith("stri") ? "True" : "False")
    );
  }
}

// ----------------------------- x x x x x  x x x x x x x  x  x x x  x x x x  x x x x ---------------

public class Trie {

  // Node structure for Trie
  static class Node {

    // Array to store links to child nodes, each index represents a letter
    Node[] links = new Node[26];

    // Flag indicating if the node marks the end of a word
    boolean flag = false;

    // Check if the node contains a specific key (letter)
    boolean containsKey(char ch) {
      return links[ch - 'a'] != null;
    }

    // Insert a new node with a specific key (letter) into the Trie
    void put(char ch, Node node) {
      links[ch - 'a'] = node;
    }

    // Get the node with a specific key (letter) from the Trie
    Node get(char ch) {
      return links[ch - 'a'];
    }

    // Set the current node as the end of a word
    void setEnd() {
      flag = true;
    }

    // Check if the current node marks the end of a word
    boolean isEnd() {
      return flag;
    }
  }

  // Trie class
  private Node root;

  // Constructor to initialize the
  // Trie with an empty root node
  public Trie() {
    root = new Node();
  }

  // Inserts a word into the Trie
  // Time Complexity O(len), where len
  // is the length of the word
  public void insert(String word) {
    Node node = root;
    for (int i = 0; i < word.length(); i++) {
      if (!node.containsKey(word.charAt(i))) {
        // Create a new node for
        // the letter if not present
        node.put(word.charAt(i), new Node());
      }
      // Move to the next node
      node = node.get(word.charAt(i));
    }
    // Mark the end of the word
    node.setEnd();
  }

  // Returns if the word
  // is in the trie
  public boolean search(String word) {
    Node node = root;
    for (int i = 0; i < word.length(); i++) {
      if (!node.containsKey(word.charAt(i))) {
        // If a letter is not found,
        // the word is not in the Trie
        return false;
      }
      // Move to the next node
      node = node.get(word.charAt(i));
    }
    // Check if the last node
    // marks the end of a word
    return node.isEnd();
  }

  // Returns if there is any word in the
  // trie that starts with the given prefix
  public boolean startsWith(String prefix) {
    Node node = root;
    for (int i = 0; i < prefix.length(); i++) {
      if (!node.containsKey(prefix.charAt(i))) {
        // If a letter is not found, there is
        // no word with the given prefix
        return false;
      }
      // Move to the next node
      node = node.get(prefix.charAt(i));
    }
    // The prefix is found in the Trie
    return true;
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    System.out.println("Inserting words: Striver, Striving, String, Strike");
    trie.insert("striver");
    trie.insert("striving");
    trie.insert("string");
    trie.insert("strike");

    System.out.println(
      "Search if Strawberry exists in trie: " +
      (trie.search("strawberry") ? "True" : "False")
    );

    System.out.println(
      "Search if Strike exists in trie: " +
      (trie.search("strike") ? "True" : "False")
    );

    System.out.println(
      "If words in Trie start with Stri: " +
      (trie.startsWith("stri") ? "True" : "False")
    );
  }
}
