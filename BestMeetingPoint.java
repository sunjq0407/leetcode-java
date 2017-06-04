public class Solution {
    public int minTotalDistance(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        Collections.sort(row);
        Collections.sort(col);
        int pr = row.get(row.size() / 2);
        int pc = col.get(col.size() / 2);
        int ret = 0;
        for(int i : row) ret += Math.abs(i - pr);
        for(int i : col) ret += Math.abs(i - pc);
        return ret;
    }
}