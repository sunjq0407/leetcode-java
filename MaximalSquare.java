public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] f = new int[matrix.length + 1][matrix[0].length + 1];
        int ret = 0;
        for(int i = 1; i <= matrix.length; i++) {
            for(int j = 1; j <= matrix[0].length; j++) {
                if(matrix[i-1][j-1] == '1')
                    f[i][j] = Math.min(f[i-1][j-1],
                            Math.min(f[i-1][j], f[i][j-1])) + 1;
                ret = Math.max(ret, f[i][j] * f[i][j]);
            }
        }
        return ret;
    }
}