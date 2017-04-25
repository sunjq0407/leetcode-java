public class NumMatrix {
    
    int[][] sums;

    public NumMatrix(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return;
        sums = new int[matrix.length][matrix[0].length + 1];
        for(int i = 0; i < matrix.length; i++)
            for(int j = 1; j <= matrix[0].length; j++)
                sums[i][j] = sums[i][j - 1] + matrix[i][j - 1];
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ret = 0;
        for(int i = row1; i <= row2; i++)
            ret += sums[i][col2 + 1] - sums[i][col1];
        return ret;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */