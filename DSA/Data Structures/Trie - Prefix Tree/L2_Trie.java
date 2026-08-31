/** A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie(): Initializes the trie object.
void insert(string word): Inserts the string word into the trie.
int countWordsEqualTo(string word): Returns the number of instances of the string word in the trie.
int countWordsStartingWith(string prefix): Returns the number of strings in the trie that have the string prefix as a prefix.
void erase(string word): Erases the string word from the trie.
Constraints:

1 <= word.length, prefix.length <= 2000
word and prefix consist only of lowercase English letters.
At most 3 * 10^4 calls in total will be made to insert, countWordsEqualTo, countWordsStartingWith, and erase.
It is guaranteed that for any function call to erase, the string word will exist in the trie.

Example 1:

Input
["Trie", "insert", "insert", "countWordsEqualTo", "countWordsStartingWith", "erase", "countWordsEqualTo", "countWordsStartingWith", "erase", "countWordsStartingWith"]
[[], ["apple"], ["apple"], ["apple"], ["app"], ["apple"], ["apple"], ["app"], ["apple"], ["app"]]
Output
[null, null, null, 2, 2, null, 1, 1, null, 0]

Explanation
Trie trie = new Trie();
trie.insert("apple"); // Inserts "apple".
trie.insert("apple"); // Inserts another "apple".
trie.countWordsEqualTo("apple"); // There are two instances of "apple" so return 2.
trie.countWordsStartingWith("app"); // "app" is a prefix of "apple" so return 2.
trie.erase("apple"); // Erases one "apple".
trie.countWordsEqualTo("apple"); // Now there is only one instance of "apple" so return 1.
trie.countWordsStartingWith("app"); // return 1
trie.erase("apple"); // Erases "apple". Now the trie is empty.
trie.countWordsStartingWith("app"); // return 0 */

public class L2_Trie {

    // ==================== TrieNode ====================

    static class TrieNode {

        TrieNode[] links = new TrieNode[26];

        int word_count = 0;
        int prefix_count = 0;

        // Check if character exists
        boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        // Insert/create a node
        void putNode(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        // Get the next node
        TrieNode getNode(char ch) {
            return links[ch - 'a'];
        }
    }


    // ==================== Trie ====================

    static class Trie {

        TrieNode root;

        // Constructor
        public Trie() {
            root = new TrieNode();
        }

        // Insert word
        public void insert(String word) {

            TrieNode node = root;

            for (char ch : word.toCharArray()) {

                if (!node.containsKey(ch)) {
                    node.putNode(ch, new TrieNode());
                }

                // Increment prefix count
                node.prefix_count++;

                node = node.getNode(ch);
            }

            // Last node
            node.prefix_count++;
            node.word_count++;
        }


        // Count how many times the exact word exists
        public int countWordsEqualTo(String word) {

            TrieNode node = root;

            for (char ch : word.toCharArray()) {

                if (!node.containsKey(ch)) {
                    return 0;
                }

                node = node.getNode(ch);
            }

            return node.word_count;
        }


        // Count how many words start with the prefix
        public int countWordsStartingWith(String prefix) {

            TrieNode node = root;

            for (char ch : prefix.toCharArray()) {

                if (!node.containsKey(ch)) {
                    return 0;
                }

                node = node.getNode(ch);
            }

            return node.prefix_count;
        }


        // Erase one occurrence of a word
        public void erase(String word) {

            TrieNode node = root;

            for (char ch : word.toCharArray()) {

                if (node.prefix_count > 0) {
                    node.prefix_count--;
                } else {
                    return;
                }

                node = node.getNode(ch);
            }

            node.prefix_count--;

            if (node.word_count > 0) {
                node.word_count--;
            }
        }
    }


    // ==================== Main ====================

    public static void main(String[] args) {

        Trie trie = new Trie();

        // Insert words
        trie.insert("apple");
        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");
        trie.insert("banana");

        // Count exact words
        System.out.println(
            "Words equal to 'apple': "
            + trie.countWordsEqualTo("apple")
        );

        System.out.println(
            "Words equal to 'app': "
            + trie.countWordsEqualTo("app")
        );

        System.out.println(
            "Words equal to 'banana': "
            + trie.countWordsEqualTo("banana")
        );

        // Count words with prefix
        System.out.println(
            "Words starting with 'app': "
            + trie.countWordsStartingWith("app")
        );

        System.out.println(
            "Words starting with 'appl': "
            + trie.countWordsStartingWith("appl")
        );

        System.out.println(
            "Words starting with 'ban': "
            + trie.countWordsStartingWith("ban")
        );

        // Erase one occurrence
        trie.erase("apple");

        System.out.println(
            "\nAfter erasing one 'apple':"
        );

        System.out.println(
            "Words equal to 'apple': "
            + trie.countWordsEqualTo("apple")
        );

        System.out.println(
            "Words starting with 'app': "
            + trie.countWordsStartingWith("app")
        );

        // Erase another occurrence
        trie.erase("apple");

        System.out.println(
            "\nAfter erasing another 'apple':"
        );

        System.out.println(
            "Words equal to 'apple': "
            + trie.countWordsEqualTo("apple")
        );

        System.out.println(
            "Words starting with 'app': "
            + trie.countWordsStartingWith("app")
        );
    }
}
