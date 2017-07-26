public class TicTacToe {
    
    int[] rows;
    int[] cols;
    int diag;
    int antiDiag;
    int size;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diag = 0;
        antiDiag = 0;
        size = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int diff = player == 1 ? 1 : -1;
        rows[row] += diff;
        cols[col] += diff;
        if(row == col) diag += diff;
        if(row + col == size - 1) antiDiag += diff;
        if(rows[row] == size || cols[col] == size
                || diag == size || antiDiag == size)
            return 1;
        if(rows[row] == -size || cols[col] == -size
                || diag == -size || antiDiag == -size)
            return 2;
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */