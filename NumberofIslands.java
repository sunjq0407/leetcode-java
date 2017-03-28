public class Solution {
    
    Map<Integer, Integer> map;
    
    public int numIslands(char[][] grid) {
        map = new HashMap<>();
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int n = grid[0].length;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    map.put(i * n + j, i * n + j);
                    union(i * n + j, (i - 1) * n + j);
                    if(j > 0) union(i * n + j, i * n + j - 1);
                }
            }
        }
        int ret = 0;
        for(int i : map.keySet()) ret += find(i) == i ? 1 : 0;
        return ret;
    }
    
    private int find(int x) {
        if(!map.containsKey(x)) return -1;
        int parent = map.get(x);
        while(parent != map.get(parent))
            parent = map.get(parent);
        while(x != map.get(x)) {
            int next = map.get(x);
            map.put(x, parent);
            x = next;
        }
        return parent;
    }
    
    private void union(int x, int y) {
        if(!map.containsKey(x) || !map.containsKey(y)) return;
        int fx = find(x);
        int fy = find(y);
        if(fx != fy) map.put(fx, fy);
    }
}