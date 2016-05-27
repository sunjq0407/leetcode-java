public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> column = new HashSet<>();
            HashSet<Character> block = new HashSet<>();
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.' && !row.add(board[i][j])) return false;
                if(board[j][i] != '.' && !column.add(board[j][i])) return false;
                if(board[3*(i/3)+j/3][3*(i%3)+j%3] != '.' && !block.add(board[3*(i/3)+j/3][3*(i%3)+j%3])) return false;
            }
        }
        return true;
    }
}

/*
// a better solution from discuss
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int [] vset = new int [9];
        int [] hset = new int [9];
        int [] bckt = new int [9];
        int idx = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    idx = 1 << (board[i][j] - '0') ;
                    if ((hset[i] & idx) > 0 ||
                        (vset[j] & idx) > 0 ||
                        (bckt[(i / 3) * 3 + j / 3] & idx) > 0) return false;
                    hset[i] |= idx;
                    vset[j] |= idx;
                    bckt[(i / 3) * 3 + j / 3] |= idx;
                }
            }
        }
        return true;
    }
}
*/