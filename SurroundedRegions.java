public class Solution {
    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0) return;
        for(int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }
        for(int i = 0; i < board[0].length; i++) {
            dfs(board, 0, i);
            dfs(board, board.length - 1, i);
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == 'Y') board[i][j] = 'O';
            }
        }
    }
    
    private void dfs(char[][] board, int i, int j) {
        if(board[i][j] != 'O') return;
        board[i][j] = 'Y';
        if(i - 1 > 0 && i - 1 < board.length - 1 && j > 0 && j < board[0].length - 1)
            dfs(board, i - 1, j);
        if(i + 1 > 0 && i + 1 < board.length - 1 && j > 0 && j < board[0].length - 1)
            dfs(board, i + 1, j);
        if(i > 0 && i < board.length - 1 && j - 1 > 0 && j - 1 < board[0].length - 1)
            dfs(board, i, j - 1);
        if(i > 0 && i < board.length - 1 && j + 1 > 0 && j + 1 < board[0].length - 1)
            dfs(board, i, j + 1);
    }
}