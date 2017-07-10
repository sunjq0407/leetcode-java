public class NumMatrix {
    
    int[][] nums;
    int[][] tree;
    boolean valid;
    
    public NumMatrix(int[][] matrix) {
        valid = matrix.length != 0 && matrix[0].length != 0;
        if(!valid) return;
        nums = new int[matrix.length][matrix[0].length];
        tree = new int[matrix.length + 1][matrix[0].length + 1];
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++)
                update(i, j, matrix[i][j]);
    }
    
    public void update(int row, int col, int val) {
        if(!valid) return;
        for(int i = row + 1; i < tree.length; i += i & (-i))
            for(int j = col + 1; j < tree[0].length; j += j & (-j))
                tree[i][j] += val - nums[row][col];
        nums[row][col] = val;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(!valid) return 0;
        return sum(row2 + 1, col2 + 1) - sum(row1, col2 + 1) - sum(row2 + 1, col1) + sum(row1, col1);
    }
    
    private int sum(int row, int col) {
        int sum = 0;
        for(int i = row; i > 0; i -= i & (-i))
            for(int j = col; j > 0; j -= j & (-j))
                sum += tree[i][j];
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */