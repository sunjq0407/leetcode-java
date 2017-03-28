public class WordDictionary {
    
    private class TrieNode {
        Map<Character, TrieNode> ch;
        boolean hasWord;
        public TrieNode() {
            ch = new HashMap<>();
            hasWord = false;
        }
    }
    
    TrieNode head;

    /** Initialize your data structure here. */
    public WordDictionary() {
        head = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = head;
        for(char c : word.toCharArray()) {
            if(!node.ch.containsKey(c)) node.ch.put(c, new TrieNode());
            node = node.ch.get(c);
        }
        node.hasWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        Queue<TrieNode> q = new LinkedList<>();
        q.offer(head);
        for(char c : word.toCharArray()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TrieNode node = q.poll();
                if(c == '.') for(TrieNode n : node.ch.values()) q.offer(n);
                else if(node.ch.containsKey(c)) q.offer(node.ch.get(c));
            }
        }
        while(!q.isEmpty())
            if(q.poll().hasWord) return true;
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */