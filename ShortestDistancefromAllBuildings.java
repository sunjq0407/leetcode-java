public class Solution {
    public int shortestDistance(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(grid[i][j] == 1) set.add(i * n + j);
        int[][] dis = new int[m][n];
        int[][] reach = new int[m][n];
        for(int bd : set) {
            boolean[][] isVisited = new boolean[m][n];
            Queue<Integer> q = new LinkedList<>();
            q.offer(bd);
            int d = 0;
            while(!q.isEmpty()) {
                int size = q.size();
                for(int i = 0; i < size; i++) {
                    int pos = q.poll();
                    int x = pos / n;
                    int y = pos % n;
                    dis[x][y] += d;
                    if(x > 0 && grid[x - 1][y] == 0 && !isVisited[x - 1][y]) {
                        q.offer(pos - n);
                        isVisited[x - 1][y] = true;
                        reach[x - 1][y] ++;
                    }
                    if(x < m - 1 && grid[x + 1][y] == 0 && !isVisited[x + 1][y]) {
                        q.offer(pos + n);
                        isVisited[x + 1][y] = true;
                        reach[x + 1][y] ++;
                    }
                    if(y > 0 && grid[x][y - 1] == 0 && !isVisited[x][y - 1]) {
                        q.offer(pos - 1);
                        isVisited[x][y - 1] = true;
                        reach[x][y - 1] ++;
                    }
                    if(y < n - 1 && grid[x][y + 1] == 0 && !isVisited[x][y + 1]) {
                        q.offer(pos + 1);
                        isVisited[x][y + 1] = true;
                        reach[x][y + 1] ++;
                    }
                }
                d++;
            }
        }
        int ret = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(grid[i][j] == 0 && dis[i][j] != 0 && reach[i][j] == set.size())
                    ret = Math.min(ret, dis[i][j]);
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }
}