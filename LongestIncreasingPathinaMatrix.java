public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int ret = 0;
        int[][] f = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++)
                ret = Math.max(ret, dfs(matrix, f, i, j, -1));
        return ret;
    }
    
    private int dfs(int[][] matrix, int[][] f, int i, int j, int val) {
        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length
                || matrix[i][j] <= val) return 0;
        if(f[i][j] != 0) return f[i][j];
        int ret = 1;
        ret = Math.max(ret, 1 + dfs(matrix, f, i - 1, j, matrix[i][j]));
        ret = Math.max(ret, 1 + dfs(matrix, f, i + 1, j, matrix[i][j]));
        ret = Math.max(ret, 1 + dfs(matrix, f, i, j - 1, matrix[i][j]));
        ret = Math.max(ret, 1 + dfs(matrix, f, i, j + 1, matrix[i][j]));
        f[i][j] = ret;
        return ret;
    }
}