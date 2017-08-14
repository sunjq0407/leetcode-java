public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[][] cnts = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            int cnt = 0;
            int start = 0;
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 'E') {
                    cnt ++;
                } else if(grid[i][j] == 'W') {
                    for(int k = start; k < j; k++) {
                        cnts[i][k] += cnt;
                    }
                    cnt = 0;
                    start = j + 1;
                }
            }
            for(int k = start; k < grid[0].length; k++) {
                cnts[i][k] += cnt;
            }
        }
        for(int j = 0; j < grid[0].length; j++) {
            int cnt = 0;
            int start = 0;
            for(int i = 0; i < grid.length; i++) {
                if(grid[i][j] == 'E') {
                    cnt ++;
                } else if(grid[i][j] == 'W') {
                    for(int k = start; k < i; k++) {
                        cnts[k][j] += cnt;
                    }
                    cnt = 0;
                    start = i + 1;
                }
            }
            for(int k = start; k < grid.length; k++) {
                cnts[k][j] += cnt;
            }
        }
        int max = 0;
        for(int i = 0; i < cnts.length; i++) {
            for(int j = 0; j < cnts[0].length; j++) {
                if(grid[i][j] == '0') {
                    max = Math.max(max, cnts[i][j]);
                }
            }
        }
        return max;
    }
}