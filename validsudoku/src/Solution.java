import java.util.*;
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i=0; i<board.length; i++) {
            HashSet<Character> row = new HashSet<Character>();
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] != '.') {
                    if (row.contains(board[i][j])) return false;
                    row.add(board[i][j]);
                }
            }
        }
        for (int j=0; j<board.length; j++) {
            HashSet<Character> col = new HashSet<Character>();
            for (int i=0; i<board[0].length; i++) {
                if (board[i][j] != '.') {
                    if (col.contains(board[i][j])) return false;
                    col.add(board[i][j]);
                }
            }
        }
        for (int i=0; i<board.length; i += 3) {
            for (int j=0; j<board[0].length; j += 3) {
                HashSet<Character> block = new HashSet<Character>();
                for (int offset=0; offset<9; offset++) {
                    if (board[i+offset/3][j+offset%3] != '.') {
                        if (block.contains(board[i+offset/3][j+offset%3])) return false;
                        block.add(board[i+offset/3][j+offset%3]);
                    }
                }
            }
        }
        return true;
    }
}