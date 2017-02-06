public class Solution {
    public void solveSudoku(char[][] board) {
        int cnt = 0;
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++)
                if(board[i][j] == '.') cnt++;
        int id = board[0][0] == '.' ? 0 : getNext(board, 0);
        if(id != -1) helper(board, id / 9, id % 9, 0, cnt);
    }
    
    private boolean helper(char[][] board, int x, int y, int level, int cnt) {
        if(level == cnt) return true;
        Set<Character> sol = getSol(board, x, y);
        if(sol.size() == 0) return false;
        int id = getNext(board, x * 9 + y);
        int nextX = id / 9;
        int nextY = id % 9;
        for(char i : sol) {
            board[x][y] = i;
            if(helper(board, nextX, nextY, level + 1, cnt)) {
                level = cnt;
                break;
            }
        }
        if(level == cnt) return true;
        board[x][y] = '.';
        return false;
    }
    
    private int getNext(char[][] board, int id) {
        int x = id / 9;
        int y = id % 9;
        for(int i = y + 1; i < 9; i++)
            if(board[x][i] == '.')
                return x * 9 + i;
        for(int i = x + 1; i < 9; i++)
            for(int j = 0; j < 9; j++)
                if(board[i][j] == '.')
                    return i * 9 + j;
        return -1;
    }
    
    private Set<Character> getSol(char[][] board, int x, int y) {
        Set<Character> ret = new HashSet<>();
        for(int i = 1; i <= 9; i++) ret.add((char)(i + '0'));
        for(int i = 0; i < 9; i++) {
            ret.remove(board[i][y]);
            ret.remove(board[x][i]);
            ret.remove(board[3*(x/3)+i/3][3*(y/3)+i%3]);
        }
        return ret;
    }
}