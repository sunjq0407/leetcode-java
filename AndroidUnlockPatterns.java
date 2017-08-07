public class Solution {
    public int numberOfPatterns(int m, int n) {
        boolean[] board = new boolean[10];
        return dfs(board, m, n, 0, 0);
    }
    
    private int dfs(boolean[] board, int m, int n, int last, int step) {
        int ret = step < m ? 0 : 1;
        if(step >= n) return ret;
        for(int i = 1; i <= 9; i++) {
            int bp = bypass(i, last);
            if(!board[i] && (bp == -1 || board[bp])) {
                board[i] = true;
                ret += dfs(board, m, n, i, step + 1);
                board[i] = false;
            }
        }
        return ret;
    }
    
    private int bypass(int i, int j) {
        if((i == 1 && j == 3) || (i == 3 && j == 1)) {
            return 2;
        }
        if((i == 1 && j == 7) || (i == 7 && j == 1)) {
            return 4;
        }
        if((i == 3 && j == 9) || (i == 9 && j == 3)) {
            return 6;
        }
        if((i == 7 && j == 9) || (i == 9 && j == 7)) {
            return 8;
        }
        if(i + j == 10) {
            return 5;
        }
        return -1;
    }
}