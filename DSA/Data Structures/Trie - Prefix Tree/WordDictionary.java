/** Problem: Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.

WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True


 */

class WordDictionary {
    
    class Trie{
        Trie[] links = new Trie[26];
        boolean flag = false;

        boolean containsKey(char ch) {
            return links[ch-'a']!=null;
        }

        void put(char ch, Trie node){
            links[ch-'a']=node;
        }

        Trie get(char ch){
            return links[ch-'a'];
        }

        boolean isEnd(){
            return flag;
        }

        void setEnd(){
            flag = true;
        }

    }

    Trie root;

    public WordDictionary() {
        root = new Trie();
    }
    
    
    public void addWord(String word) {
        Trie node = root;

        for(char ch : word.toCharArray()){
            if(node.containsKey(ch)==false){
                node.put(ch, new Trie());
            }
            node = node.get(ch);
        }

        node.setEnd();
    }
    
    // check move
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int index, Trie node) {

        // Entire word has been processed
        if (index == word.length()) {
            return node.isEnd();
        }

        char ch = word.charAt(index);

        // Normal character
        if (ch != '.') {

            if (!node.containsKey(ch)) {
                return false;
            }

            return searchHelper(word, index + 1, node.get(ch));
        }

        // '.' -> try all 26 possible characters
        for (int i = 0; i < 26; i++) {

            if (node.links[i] != null) {

                if (searchHelper(word, index + 1, node.links[i])) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }
}

