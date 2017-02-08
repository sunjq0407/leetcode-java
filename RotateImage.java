public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n/2; i++)
            for(int j = 0; j < (n+1)/2; j++)
                helper(matrix, i, j, n);
    }
    
    private void helper(int[][] matrix, int x, int y, int n) {
        int tmp = matrix[x][y];
        matrix[x][y] = matrix[n-1-y][x];
        matrix[n-1-y][x] = matrix[n-1-x][n-1-y];
        matrix[n-1-x][n-1-y] = matrix[y][n-1-x];
        matrix[y][n-1-x] = tmp;
    }
}