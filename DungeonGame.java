public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] f = new int[m][n];
        f[m-1][n-1] = Math.max(1, 1 - dungeon[m-1][n-1]);
        for(int i = m - 2; i >= 0; i--)
            f[i][n-1] = Math.max(1, f[i+1][n-1] - dungeon[i][n-1]);
        for(int i = n - 2; i >= 0; i--)
            f[m-1][i] = Math.max(1, f[m-1][i+1] - dungeon[m-1][i]);
        for(int i = m - 2; i >= 0; i--)
            for(int j = n - 2; j >= 0; j--)
                f[i][j] = Math.max(1, Math.min(f[i+1][j], f[i][j+1]) - dungeon[i][j]);
        return f[0][0];
    }
}