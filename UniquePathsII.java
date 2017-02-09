public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m == 0 || obstacleGrid[0].length == 0) return 0;
        int n = obstacleGrid[0].length;
        int[][] f = new int[m+1][n+1];
        f[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for(int i = 1; i < m; i++)
            f[i][0] = obstacleGrid[i][0] == 0 ? f[i-1][0] : 0;
        for(int i = 1; i < n; i++) 
            f[0][i] = obstacleGrid[0][i] == 0 ? f[0][i-1] : 0;
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 1) f[i][j] = 0;
                else f[i][j] = f[i-1][j] + f[i][j-1];
            }
        }
        return f[m-1][n-1];
    }
}