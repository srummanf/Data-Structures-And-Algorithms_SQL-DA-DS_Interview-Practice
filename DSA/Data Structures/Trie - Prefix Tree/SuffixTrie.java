public class SuffixTrie {

  // Same True DS
  static class Node {

    Node[] links = new Node[26];
    boolean flag = false;

    //Check
    boolean containsKey(char ch) {
      return links[ch - 'a'] != null;
    }

    //Create
    void put(char ch, Node node) {
      links[ch - 'a'] = node;
    }

    //Move
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

  public SuffixTrie() {
    root = new Node();
  }


  public void insert(String word) {
    for (int i = 0; i < word.length(); i++) {
      Node node = root;
      // Extra Loop 
      for (int j = i; j < word.length(); j++) {
        //Check
        if (!node.containsKey(word.charAt(j))) {
          // Create
          node.put(word.charAt(j), new Node());
        }
        // Move 
        node = node.get(word.charAt(j));
      }
      // Mark the end of the word
      node.setEnd();
    }
  }


  public boolean search(String word) {
    Node node = root;
    for (int i = 0; i < word.length(); i++) {
      //Check
      if (!node.containsKey(word.charAt(i))) {
        return false;
      }
      // Move 
      node = node.get(word.charAt(i));
    }

    return node.isEnd();
  }

  
  public boolean startsWith(String prefix) {
    Node node = root;
    for (int i = 0; i < prefix.length(); i++) {
      //Check
      if (!node.containsKey(prefix.charAt(i))) {
        return false;
      }
      // Move
      node = node.get(prefix.charAt(i));
    }

    return true;
  }

  // Same as that of search
  public boolean endsWith(String suffix) {
    Node node = root;
    for (int i = 0; i < suffix.length(); i++) {
      //Check
      if (!node.containsKey(suffix.charAt(i))) {
        return false;
      }
      // Move
      node = node.get(suffix.charAt(i));
    }
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