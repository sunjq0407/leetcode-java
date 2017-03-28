public class Trie {
    
    private class TrieNode {
        HashMap<Character, TrieNode> ch;
        boolean hasWord;
        public TrieNode() {
            ch = new HashMap<>();
            hasWord = false;
        }
    }
    
    TrieNode head;

    /** Initialize your data structure here. */
    public Trie() {
        head = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = head;
        for(char c : word.toCharArray()) {
            if(!node.ch.containsKey(c)) node.ch.put(c, new TrieNode());
            node = node.ch.get(c);
        }
        node.hasWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = head;
        for(char c : word.toCharArray()) {
            if(!node.ch.containsKey(c)) return false;
            node = node.ch.get(c);
        }
        return node.hasWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = head;
        for(char c : prefix.toCharArray()) {
            if(!node.ch.containsKey(c)) return false;
            node = node.ch.get(c);
        }
        return node.hasWord || node.ch.values().size() > 0;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */