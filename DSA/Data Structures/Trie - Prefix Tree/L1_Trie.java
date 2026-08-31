
public class L1_Trie {

    /*
     * ============================================================
     *                    TRIE NODE
     * ============================================================
     *
     * A Trie is basically a TREE where:
     *
     *      Each EDGE  -> represents a character
     *      Each NODE  -> represents a position/prefix
     *
     * Example:
     *
     * Insert: "cat"
     *
     *             root
     *              |
     *              c
     *              |
     *              a
     *              |
     *              t*
     *
     * '*' means this node marks the END of a complete word.
     *
     * ------------------------------------------------------------
     * Why do we need a Node?
     * ------------------------------------------------------------
     *
     * Every character needs a place to go.
     *
     * For lowercase English letters, a node can have at most
     * 26 children.
     *
     *              Node
     *            /  |  \
     *           a   b   c ... z
     *
     * Therefore:
     *
     * Node[] links = new Node[26];
     *
     * links[0] -> 'a'
     * links[1] -> 'b'
     * links[2] -> 'c'
     * ...
     * links[25] -> 'z'
     */

    static class Node {

        // Each index represents one lowercase character.
        //
        // links[0]  -> a
        // links[1]  -> b
        // ...
        // links[25] -> z
        //
        // Initially all values are null because no child exists.
        Node[] links = new Node[26];


        /*
         * flag tells us:
         *
         * "Does a complete word end at THIS node?"
         *
         * Example:
         *
         * Insert "app"
         *
         * root -> a -> p -> p
         *                  ^
         *                  |
         *               flag = true
         *
         * If we also insert "apple":
         *
         * root -> a -> p -> p -> l -> e
         *                  ^         ^
         *                  |         |
         *                END        END
         *
         * "app" is a word AND "apple" is a word.
         */
        boolean flag = false;


        /*
         * ========================================================
         * containsKey()
         * ========================================================
         *
         * Question:
         *
         * "Does this node already have a child for character ch?"
         *
         * Example:
         *
         * ch = 'c'
         *
         * ch - 'a'
         *
         * 'c' - 'a' = 2
         *
         * Therefore we check:
         *
         * links[2]
         *
         * If it is not null:
         *
         *       child exists
         *
         * If it is null:
         *
         *       child doesn't exist
         */
        boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }


        /*
         * ========================================================
         * put()
         * ========================================================
         *
         * Create/store a child node for character ch.
         *
         * Example:
         *
         * put('c', new Node())
         *
         * means:
         *
         * links[2] = new Node()
         *
         * Remember:
         *
         * containsKey -> CHECK
         * put         -> CREATE/STORE
         */
        void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }


        /*
         * ========================================================
         * get()
         * ========================================================
         *
         * Get the child node corresponding to character ch.
         *
         * Example:
         *
         * node.get('c')
         *
         * means:
         *
         * "Give me the Node connected through 'c'."
         *
         * Remember:
         *
         * put -> PUT the child
         * get -> GET the child
         */
        Node get(char ch) {
            return links[ch - 'a'];
        }


        /*
         * ========================================================
         * setEnd()
         * ========================================================
         *
         * Mark this node as the END of a complete word.
         *
         * Example:
         *
         * Insert "cat"
         *
         * root -> c -> a -> t
         *                  ^
         *                  |
         *              setEnd()
         *
         * Now:
         *
         * t.flag = true
         */
        void setEnd() {
            flag = true;
        }


        /*
         * ========================================================
         * isEnd()
         * ========================================================
         *
         * Ask:
         *
         * "Does a complete word end at this node?"
         *
         * Example:
         *
         * Insert "app"
         *
         * Search "app"
         *
         * We reach the second 'p'.
         *
         * isEnd() -> true
         *
         * But searching "ap" gives:
         *
         * isEnd() -> false
         *
         * because "ap" is only a prefix, not a complete word.
         */
        boolean isEnd() {
            return flag;
        }
    }


    /*
     * ============================================================
     *                         TRIE
     * ============================================================
     *
     * The Trie itself needs ONE starting node.
     *
     * This is called ROOT.
     *
     * root
     *   |
     *   +---- children
     *
     * IMPORTANT:
     *
     * root does NOT represent a character.
     *
     * It is simply the starting point.
     */
    Node root;


    /*
     * Constructor
     *
     * Create an empty Trie.
     *
     * root = new Node()
     *
     *              root
     *             / | \
     *           null...
     */
    L1_Trie() {
        root = new Node();
    }


    /*
     * ============================================================
     *                         INSERT
     * ============================================================
     *
     * Goal:
     *
     * Insert a word into the Trie.
     *
     * Example:
     *
     * insert("cat")
     *
     * Step 1: root
     * Step 2: create/get 'c'
     * Step 3: create/get 'a'
     * Step 4: create/get 't'
     * Step 5: mark 't' as END
     *
     * ============================================================
     *
     * THE INSERT MNEMONIC:
     *
     *       CHECK -> CREATE -> MOVE -> MARK END
     *
     * For every character:
     *
     *       1. Does child exist?
     *       2. If not, create it.
     *       3. Move to that child.
     *
     * Finally:
     *
     *       MARK END
     *
     * ============================================================
     */
    public void insert(String word) {

        /*
         * VERY IMPORTANT:
         *
         * We MUST start from ROOT.
         *
         * NOT:
         *
         * Node node = new Node();   <-- WRONG
         *
         * because that creates a completely separate Node.
         *
         * Correct:
         */
        Node node = root;


        // Process every character in the word.
        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);


            /*
             * STEP 1: CHECK
             *
             * Does this character already have a child?
             */
            if (!node.containsKey(ch)) {

                /*
                 * STEP 2: CREATE
                 *
                 * No child exists.
                 *
                 * Create one and connect it.
                 */
                node.put(ch, new Node());
            }


            /*
             * STEP 3: MOVE
             *
             * Move to the child corresponding to ch.
             *
             * This is extremely important.
             *
             * We are walking down the Trie.
             */
            node = node.get(ch);
        }


        /*
         * We have processed the complete word.
         *
         * Mark the current node as the END of the word.
         */
        node.setEnd();
    }


    /*
     * ============================================================
     *                         SEARCH
     * ============================================================
     *
     * Goal:
     *
     * Check whether the EXACT word exists.
     *
     * Example:
     *
     * Insert:
     *
     * "apple"
     *
     * search("app")
     *
     *        -> false
     *
     * because "app" is only a prefix.
     *
     * search("apple")
     *
     *        -> true
     *
     * ============================================================
     *
     * SEARCH MNEMONIC:
     *
     *       CHECK -> MOVE -> MARK END
     *
     * For every character:
     *
     *       1. Does the path exist?
     *       2. If not -> FALSE
     *       3. If yes -> MOVE
     *
     * After the loop:
     *
     *       Is this node an END?
     *
     * ============================================================
     */
    public boolean search(String word) {

        // Always start from root.
        Node node = root;


        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);


            /*
             * CHECK:
             *
             * If there is no path for this character,
             * the word cannot exist.
             */
            if (!node.containsKey(ch)) {
                return false;
            }


            /*
             * MOVE:
             *
             * Follow the character's child.
             */
            node = node.get(ch);
        }


        /*
         * We successfully followed every character.
         *
         * BUT:
         *
         * Reaching the node is NOT enough.
         *
         * We need to know whether a COMPLETE WORD ends here.
         *
         * Therefore:
         *
         *       return node.isEnd();
         */
        return node.isEnd();
    }


    /*
     * ============================================================
     *                       STARTS WITH
     * ============================================================
     *
     * Goal:
     *
     * Check whether ANY word starts with the given prefix.
     *
     * Example:
     *
     * Insert:
     *
     * "apple"
     * "application"
     * "apply"
     *
     * startsWith("app") -> true
     *
     * We DO NOT care whether "app" itself is a complete word.
     *
     * We only care whether the PATH exists.
     *
     * ============================================================
     *
     * STARTS WITH MNEMONIC:
     *
     *       CHECK -> MOVE -> DONE
     *
     * No isEnd() at the end!
     *
     * Why?
     *
     * Because we only care whether the prefix path exists.
     *
     * ============================================================
     */
    public boolean startsWith(String prefix) {

        // Start at root.
        Node node = root;


        for (int i = 0; i < prefix.length(); i++) {

            char ch = prefix.charAt(i);


            /*
             * If the path doesn't exist,
             * no word can have this prefix.
             */
            if (!node.containsKey(ch)) {
                return false;
            }


            /*
             * Path exists.
             *
             * Move forward.
             */
            node = node.get(ch);
        }


        /*
         * We successfully followed the COMPLETE prefix.
         *
         * Therefore at least one word has this prefix.
         *
         * Notice:
         *
         * We DO NOT call isEnd().
         */
        return true;
    }


    /*
     * ============================================================
     *                          MAIN
     * ============================================================
     */
    public static void main(String[] args) {

        // Create an empty Trie.
        L1_Trie trie = new L1_Trie();


        /*
         * Insert words:
         *
         * striver
         * striving
         * string
         * strike
         *
         * Notice how many words share:
         *
         * s -> t -> r -> i
         *
         * This is exactly where a Trie saves space and
         * makes prefix operations efficient.
         */
        System.out.println(
            "Inserting words: Striver, Striving, String, Strike"
        );

        trie.insert("striver");
        trie.insert("striving");
        trie.insert("string");
        trie.insert("strike");


        /*
         * Search for "strawberry"
         *
         * The path will break somewhere because no such path
         * exists in our Trie.
         */
        System.out.println(
            "Search if Strawberry exists in trie: " +
            (trie.search("strawberry") ? "True" : "False")
        );


        /*
         * Search for "strike"
         *
         * The complete path exists AND the final node is marked
         * as END.
         *
         * Therefore -> true.
         */
        System.out.println(
            "Search if Strike exists in trie: " +
            (trie.search("strike") ? "True" : "False")
        );


        /*
         * Check prefix "stri"
         *
         * We only need to know whether this PATH exists.
         *
         * We don't care whether "stri" itself is a word.
         */
        System.out.println(
            "If words in Trie start with Stri: " +
            (trie.startsWith("stri") ? "True" : "False")
        );
    }
}
// ```

// ### The Trie mnemonic I recommend

// Don't memorize the code line-by-line. Memorize this:

// ```text
//                  TRIE
//                   |
//           -------------------
//           |        |        |
//         INSERT   SEARCH   STARTS WITH
//           |        |        |
//        CHECK    CHECK    CHECK
//           |        |        |
//        CREATE    MOVE     MOVE
//           |        |        |
//         MOVE     CHECK    DONE
//           |
//        MARK END
// ```

// Or even shorter:

// > **INSERT = Check → Create → Move → End**

// > **SEARCH = Check → Move → End?**

// > **STARTS WITH = Check → Move → Done**

// That's the entire basic Trie.

// ### The 5 functions inside `Node`

// Another useful mnemonic:

// ```text
// containsKey(ch)  → "Does it exist?"
// put(ch, node)    → "Create/connect it"
// get(ch)          → "Go there"
// setEnd()         → "Word ends here"
// isEnd()          → "Does word end here?"
// ```

// Think of them as:

// ```text
// CHECK → PUT → GET → MARK → CHECK END
// ```

// ### The most important distinction

// This is where many beginners get confused:

// ```java
// search("app")
// ```

// asks:

// > **"Is `app` a complete word?"**

// Therefore:

// ```java
// return node.isEnd();
// ```

// But:

// ```java
// startsWith("app")
// ```

// asks:

// > **"Does any word have `app` as its prefix?"**

// Therefore:

// ```java
// return true;
// ```

// No `isEnd()`.

// For example, if the Trie contains only:

// ```text
// apple
// ```

// then:

// ```text
// search("app")       → false
// startsWith("app")   → true
// search("apple")     → true
// ```

// ### One mental picture to keep in your head

// Whenever you see a Trie problem, imagine this:

// ```text
//                     root
//                      |
//                      s
//                      |
//                      t
//                      |
//                      r
//                      |
//                      i
//                   /  |  |  \
//                  v   n  k   ...
//                  |   |  |
//                  e   g  e
//                  |   |  |
//                  r   ... ...
//                  *
// ```

// And imagine a pointer:

// ```java
// Node node = root;
// ```

// Then for every character:

// ```java
// if (!node.containsKey(ch)) {
//     // path doesn't exist
// }

// node = node.get(ch);  // walk down
// ```

// **That `node` variable is simply your finger walking down the Trie.**

// This mental model is more useful than memorizing the implementation.
































































// --------------------x-------------------------x----------------------------x---------------------------x---------------------

// public class L1_Trie {

//   static class Node {

//     Node[] links = new Node[26];
//     boolean flag = false;

//     boolean containsKey(char ch) {
//       return links[ch - 'a'] != null;
//     }

//     void put(char ch, Node node) {
//       links[ch - 'a'] = node;
//     }

//     Node get(char ch) {
//       return links[ch - 'a'];
//     }

//     void setEnd() {
//       flag = true;
//     }

//     boolean isEnd() {
//       return flag;
//     }
//   }

//   Node root;

//   L1_Trie() {
//     root = new Node();
//   }

//   public void insert(String word) {
//     Node node = new Node();
//     for (int i = 0; i < word.length(); i++) {
//       if (!node.containsKey(word.charAt(i))) {
//         node.put(word.charAt(i), new Node());
//       }
//       node = node.get(word.charAt(i));
//     }
//     node.setEnd();
//   }

//   public boolean search(String word) {
//     Node node = root;
//     for (int i = 0; i < word.length(); i++) {
//       if (!node.containsKey(word.charAt(i))) {
//         return false;
//       }
//       node = node.get(word.charAt(i));
//     }
//     return node.isEnd();
//   }

//   public boolean startsWith(String prefix) {
//     Node node = root;
//     for (int i = 0; i < prefix.length(); i++) {
//       if (!node.containsKey(prefix.charAt(i))) {
//         return false;
//       }
//       node = node.get(prefix.charAt(i));
//     }
//     return true;
//   }

//   public static void main(String[] args) {
//     L1_Trie trie = new L1_Trie();
//     System.out.println("Inserting words: Striver, Striving, String, Strike");
//     trie.insert("striver");
//     trie.insert("striving");
//     trie.insert("string");
//     trie.insert("strike");

//     System.out.println(
//       "Search if Strawberry exists in trie: " +
//       (trie.search("strawberry") ? "True" : "False")
//     );

//     System.out.println(
//       "Search if Strike exists in trie: " +
//       (trie.search("strike") ? "True" : "False")
//     );

//     System.out.println(
//       "If words in Trie start with Stri: " +
//       (trie.startsWith("stri") ? "True" : "False")
//     );
//   }
// }





// ----------------------------- x x x x x  x x x x x x x  x  x x x  x x x x  x x x x ---------------

// public class L1_Trie {

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

//   // Constructor to initialize the
//   // Trie with an empty root node
//   public L1_Trie() {
//     root = new Node();
//   }

//   // Inserts a word into the Trie
//   // Time Complexity O(len), where len
//   // is the length of the word
//   public void insert(String word) {
//     Node node = root;
//     for (int i = 0; i < word.length(); i++) {
//       if (!node.containsKey(word.charAt(i))) {
//         // Create a new node for
//         // the letter if not present
//         node.put(word.charAt(i), new Node());
//       }
//       // Move to the next node
//       node = node.get(word.charAt(i));
//     }
//     // Mark the end of the word
//     node.setEnd();
//   }

//   // Returns if the word
//   // is in the trie
//   public boolean search(String word) {
//     Node node = root;
//     for (int i = 0; i < word.length(); i++) {
//       if (!node.containsKey(word.charAt(i))) {
//         // If a letter is not found,
//         // the word is not in the Trie
//         return false;
//       }
//       // Move to the next node
//       node = node.get(word.charAt(i));
//     }
//     // Check if the last node
//     // marks the end of a word
//     return node.isEnd();
//   }

//   // Returns if there is any word in the
//   // trie that starts with the given prefix
//   public boolean startsWith(String prefix) {
//     Node node = root;
//     for (int i = 0; i < prefix.length(); i++) {
//       if (!node.containsKey(prefix.charAt(i))) {
//         // If a letter is not found, there is
//         // no word with the given prefix
//         return false;
//       }
//       // Move to the next node
//       node = node.get(prefix.charAt(i));
//     }
//     // The prefix is found in the Trie
//     return true;
//   }

//   public static void main(String[] args) {
//     L1_Trie trie = new L1_Trie();
//     System.out.println("Inserting words: Striver, Striving, String, Strike");
//     trie.insert("striver");
//     trie.insert("striving");
//     trie.insert("string");
//     trie.insert("strike");

//     System.out.println(
//       "Search if Strawberry exists in trie: " +
//       (trie.search("strawberry") ? "True" : "False")
//     );

//     System.out.println(
//       "Search if Strike exists in trie: " +
//       (trie.search("strike") ? "True" : "False")
//     );

//     System.out.println(
//       "If words in Trie start with Stri: " +
//       (trie.startsWith("stri") ? "True" : "False")
//     );
//   }
// }
