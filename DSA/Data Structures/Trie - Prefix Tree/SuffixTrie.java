public class SuffixTrie {

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

  // Constructor to initialize the Trie with an empty root node
  public SuffixTrie() {
    root = new Node();
  }

  // Inserts all suffixes of a word into the Trie
  public void insert(String word) {
    for (int i = 0; i < word.length(); i++) {
      Node node = root;
      for (int j = i; j < word.length(); j++) {
        if (!node.containsKey(word.charAt(j))) {
          // Create a new node for the letter if not present
          node.put(word.charAt(j), new Node());
        }
        // Move to the next node
        node = node.get(word.charAt(j));
      }
      // Mark the end of the word
      node.setEnd();
    }
  }

  // Returns if the word is in the trie
  public boolean search(String word) {
    Node node = root;
    for (int i = 0; i < word.length(); i++) {
      if (!node.containsKey(word.charAt(i))) {
        // If a letter is not found, the word is not in the Trie
        return false;
      }
      // Move to the next node
      node = node.get(word.charAt(i));
    }
    // Check if the last node marks the end of a word
    return node.isEnd();
  }

  // Returns if there is any word in the trie that starts with the given prefix
  public boolean startsWith(String prefix) {
    Node node = root;
    for (int i = 0; i < prefix.length(); i++) {
      if (!node.containsKey(prefix.charAt(i))) {
        // If a letter is not found, there is no word with the given prefix
        return false;
      }
      // Move to the next node
      node = node.get(prefix.charAt(i));
    }
    // The prefix is found in the Trie
    return true;
  }

  // Returns if any word in the trie ends with the given suffix
  public boolean endsWith(String suffix) {
    Node node = root;
    for (int i = 0; i < suffix.length(); i++) {
      if (!node.containsKey(suffix.charAt(i))) {
        // If a letter is not found, there is no word with the given suffix
        return false;
      }
      // Move to the next node
      node = node.get(suffix.charAt(i));
    }
    // Check if the node marks the end of any word in the Trie
    return node.isEnd();
  }

  public static void main(String[] args) {
    SuffixTrie suffixTrie = new SuffixTrie();
    String word = "bananas";

    System.out.println("Inserting all suffixes of the word: " + word);
    suffixTrie.insert(word);

    System.out.println(
      "Search if 'anas' exists in trie: " +
      (suffixTrie.search("anas") ? "True" : "False")
    );
    System.out.println(
      "Search if 'banana' exists in trie: " +
      (suffixTrie.search("banana") ? "True" : "False")
    );
    System.out.println(
      "Search if 'nana' exists in trie: " +
      (suffixTrie.search("nana") ? "True" : "False")
    );
    System.out.println(
      "If words in Trie start with 'ban': " +
      (suffixTrie.startsWith("ban") ? "True" : "False")
    );
    System.out.println(
      "If words in Trie start with 'nana': " +
      (suffixTrie.startsWith("nana") ? "True" : "False")
    );
    System.out.println(
      "If words in Trie end with 'anas': " +
      (suffixTrie.endsWith("anas") ? "True" : "False")
    );
  }
}
// public class SuffixTrie {
//   // Node structure for Trie
//   static class Node {
//     // Array to store links to child nodes, each index represents a letter
//     Node[] links = new Node[26];
//     // Flag indicating if the node marks the end of a word
//     boolean flag = false;
//     // Check if the node contains a specific key (letter)
//     boolean containsKey(char ch) {
//       return links[ch - 'a'] != null;
//     }
//     // Insert a new node with a specific key (letter) into the Trie
//     void put(char ch, Node node) {
//       links[ch - 'a'] = node;
//     }
//     // Get the node with a specific key (letter) from the Trie
//     Node get(char ch) {
//       return links[ch - 'a'];
//     }
//     // Set the current node as the end of a word
//     void setEnd() {
//       flag = true;
//     }
//     // Check if the current node marks the end of a word
//     boolean isEnd() {
//       return flag;
//     }
//   }
//   // Trie class
//   private Node root;
//   // Constructor to initialize the Trie with an empty root node
//   public SuffixTrie() {
//     root = new Node();
//   }
//   // Inserts a suffix into the Trie
//   public void insertSuffix(String suffix) {
//     Node node = root;
//     for (int i = 0; i < suffix.length(); i++) {
//       if (!node.containsKey(suffix.charAt(i))) {
//         // Create a new node for the letter if not present
//         node.put(suffix.charAt(i), new Node());
//       }
//       // Move to the next node
//       node = node.get(suffix.charAt(i));
//     }
//     // Mark the end of the word
//     node.setEnd();
//   }
//   // Inserts all suffixes of a word into the Trie
//   public void insert(String word) {
//     for (int i = 0; i < word.length(); i++) {
//       insertSuffix(word.substring(i));
//     }
//   }
//   // Returns if the word is in the trie
//   public boolean search(String word) {
//     Node node = root;
//     for (int i = 0; i < word.length(); i++) {
//       if (!node.containsKey(word.charAt(i))) {
//         // If a letter is not found, the word is not in the Trie
//         return false;
//       }
//       // Move to the next node
//       node = node.get(word.charAt(i));
//     }
//     // Check if the last node marks the end of a word
//     return node.isEnd();
//   }
//   // Returns if there is any word in the trie that starts with the given prefix
//   public boolean startsWith(String prefix) {
//     Node node = root;
//     for (int i = 0; i < prefix.length(); i++) {
//       if (!node.containsKey(prefix.charAt(i))) {
//         // If a letter is not found, there is no word with the given prefix
//         return false;
//       }
//       // Move to the next node
//       node = node.get(prefix.charAt(i));
//     }
//     // The prefix is found in the Trie
//     return true;
//   }
//   // Returns if any word in the trie ends with the given suffix
//   public boolean endsWith(String suffix) {
//     Node node = root;
//     for (int i = 0; i < suffix.length(); i++) {
//       if (!node.containsKey(suffix.charAt(i))) {
//         // If a letter is not found, there is no word with the given suffix
//         return false;
//       }
//       // Move to the next node
//       node = node.get(suffix.charAt(i));
//     }
//     // Check if the node marks the end of any word in the Trie
//     return node.isEnd();
//   }
//   public static void main(String[] args) {
//     SuffixTrie suffixTrie = new SuffixTrie();
//     String word = "bananas";
//     System.out.println("Inserting all suffixes of the word: " + word);
//     suffixTrie.insert(word);
//     System.out.println("Search if 'anas' exists in trie: " + (suffixTrie.search("anas") ? "True" : "False"));
//     System.out.println("Search if 'banana' exists in trie: " + (suffixTrie.search("banana") ? "True" : "False"));
//     System.out.println("Search if 'nana' exists in trie: " + (suffixTrie.search("nana") ? "True" : "False"));
//     System.out.println("If words in Trie start with 'ban': " + (suffixTrie.startsWith("ban") ? "True" : "False"));
//     System.out.println("If words in Trie start with 'nana': " + (suffixTrie.startsWith("nana") ? "True" : "False"));
//     System.out.println("If words in Trie end with 'anas': " + (suffixTrie.endsWith("ana") ? "True" : "False"));
//   }
// }
