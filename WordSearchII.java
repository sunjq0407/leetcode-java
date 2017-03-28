public class Solution {
    
    private class TrieNode {
        Map<Character, TrieNode> ch;
        boolean hasWord;
        public TrieNode() {
            ch = new HashMap<>();
            hasWord = false;
        }
    }
    
    private void insert(String str, TrieNode head) {
        for(char c : str.toCharArray()) {
            if(!head.ch.containsKey(c)) head.ch.put(c, new TrieNode());
            head = head.ch.get(c);
        }
        head.hasWord = true;
    }
        
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ret = new ArrayList<>();
        if(board.length == 0 || board[0].length == 0) return ret;
        TrieNode head = new TrieNode();
        for(String str : words) insert(str, head);
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++)
                dfs(board, i, j, head, "", ret);
        return ret;
    }
    
    private void dfs(char[][] board, int i, int j, TrieNode head, String str,
            List<String> ret) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;
        char c = board[i][j];
        if(c == '#' || ! head.ch.containsKey(c)) return;
        head = head.ch.get(c);
        str += c;
        if(head.hasWord) {
            ret.add(str);
            head.hasWord = false;
        }
        board[i][j] = '#';
        dfs(board, i - 1, j, head, str, ret);
        dfs(board, i + 1, j, head, str, ret);
        dfs(board, i, j - 1, head, str, ret);
        dfs(board, i, j + 1, head, str, ret);
        board[i][j] = c;
    }
}