public class Solution {
    public void gameOfLife(int[][] board) {
        if(board.length == 0 || board[0].length == 0) return;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int nb = helper(board, i, j);
                if(board[i][j] == 1 && (nb == 2 || nb == 3))
                    board[i][j] = 3;
                else if(board[i][j] == 0 && nb == 3) board[i][j] = 2;
            }
        }
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++)
                board[i][j] >>= 1;
    }
    
    private int helper(int[][] board, int x, int y) {
        int cnt = 0;
        for(int i = Math.max(0, x - 1); i <= Math.min(board.length - 1, x + 1); i++)
            for(int j = Math.max(0, y - 1); j <= Math.min(board[0].length - 1, y + 1); j++)
                cnt += board[i][j] & 1;
        return (board[x][y] & 1) == 1 ? cnt - 1 : cnt;
    }
}