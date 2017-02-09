public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int num = 1;
        for(int i = 0; i < (n + 1) / 2; i++) {
            for(int j = i; j < n-i; j++) ret[i][j] = num++;
            for(int j = i + 1; j < n-i; j++) ret[j][n-1-i] = num++;
            for(int j = n-2-i; j >= i; j--) ret[n-1-i][j] = num++;
            for(int j = n-2-i; j > i; j--) ret[j][i] = num++;
        }
        return ret;
    }
}