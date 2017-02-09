public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0) return ret;
        helper(matrix, 0, 0, ret);
        return ret;
    }
    
    private void helper(int[][] matrix, int x, int y, List<Integer> ret) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(x >= (m + 1) / 2 || y >= (n + 1) / 2) return;
        int up = x;
        int left = y;
        int down = m - 1 - x;
        int right = n - 1 - y;
        for(int i = left; i <= right; i++) ret.add(matrix[up][i]);
        if(up + 1 > down) return;
        for(int i = up + 1; i <= down; i++) ret.add(matrix[i][right]);
        if(right - 1 < left) return;
        for(int i = right - 1; i >= left; i--) ret.add(matrix[down][i]);
        for(int i = down - 1; i > up; i--) ret.add(matrix[i][left]);
        helper(matrix, x + 1, y + 1, ret);
    }
}