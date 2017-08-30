class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int l = matrix[0][0];
        int r = matrix[matrix.length - 1][matrix[0].length - 1];
        while(l <= r) {
            int mid = (r - l) / 2 + l;
            int n = countSmaller(matrix, mid);
            if(n < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
    
    private int countSmaller(int[][] matrix, int val) {
        int cnt = 0;
        int j = matrix[0].length - 1;
        for(int i = 0; i < matrix.length; i++) {
            while(j >= 0 && matrix[i][j] > val) {
                j --;
            }
            if(j < 0) {
                break;
            }
            cnt += j + 1;
        }
        return cnt;
    }
}