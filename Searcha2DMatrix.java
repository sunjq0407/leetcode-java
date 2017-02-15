public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        if(matrix[0][0] > target || matrix[m-1][n-1] < target) return false;
        int l = 0;
        int r = m - 1;
        int row = -1;
        while(l + 1 < r) {
            int mid = (r + l) / 2;
            if(matrix[mid][0] > target) r = mid - 1;
            else if(matrix[mid][n-1] < target) l = mid + 1;
            else {
                row = mid;
                break;
            }
        }
        if(row == -1) {
            if(matrix[l][n-1] >= target) row = l;
            else if(matrix[r][0] <= target) row = r;
            else return false;
        }
        l = 0;
        r = n - 1;
        while(l + 1 < r) {
            int mid = (r + l) / 2;
            if(matrix[row][mid] > target) r = mid - 1;
            else if(matrix[row][mid] < target) l = mid + 1;
            else return true;
        }
        return matrix[row][l] == target || matrix[row][r] == target;
    }
}