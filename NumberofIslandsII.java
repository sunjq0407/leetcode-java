public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ret = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        boolean[][] arr = new boolean[m][n];
        int cnt = 0;
        for(int i = 0; i < positions.length; i++) {
            int x = positions[i][0];
            int y = positions[i][1];
            if(!arr[x][y]) cnt ++;
            arr[x][y] = true;
            map.put(x * n + y, x * n + y);
            if(x >= 1 && arr[x - 1][y] && union((x - 1) * n + y, x * n + y, map)) cnt --;
            if(x + 1 < m && arr[x + 1][y] && union((x + 1) * n + y, x * n + y, map)) cnt --;
            if(y >= 1 && arr[x][y - 1] && union(x * n + y - 1, x * n + y, map)) cnt --;
            if(y + 1 < n && arr[x][y + 1] && union(x * n + y + 1, x * n + y, map)) cnt --;
            ret.add(cnt);
        }
        return ret;
    }
    
    private int find(int x, Map<Integer, Integer> map) {
        int father = map.get(x);
        while(map.get(father) != father) father = map.get(father);
        while(x != father) {
            int next = map.get(x);
            map.put(x, father);
            x = next;
        }
        return father;
    }
    
    private boolean union(int x, int y, Map<Integer, Integer> map) {
        int fx = find(x, map);
        int fy = find(y, map);
        if(fx == fy) return false;
        map.put(fy, fx);
        return true;
    }
}