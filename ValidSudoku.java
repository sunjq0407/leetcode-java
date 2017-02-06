public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> block = new HashSet<>();
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.' && row.contains(board[i][j])) return false;
                else row.add(board[i][j]);
                if(board[j][i] != '.' && col.contains(board[j][i])) return false;
                else col.add(board[j][i]);
                if(board[3*(i/3)+j/3][3*(i%3)+j%3] != '.' 
                        && block.contains(board[3*(i/3)+j/3][3*(i%3)+j%3])) return false;
                else block.add(board[3*(i/3)+j/3][3*(i%3)+j%3]);
            }
        }
        return true;
    }
}