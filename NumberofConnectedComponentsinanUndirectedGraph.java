public class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) map.put(i, i);
        for(int i = 0; i < edges.length; i++)
            union(edges[i][0], edges[i][1], map);
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) set.add(find(i, map));
        return set.size();
    }
    
    private int find(int x, Map<Integer, Integer> map) {
        int parent = map.get(x);
        while(parent != map.get(parent)) parent = map.get(parent);
        while(map.get(x) != parent) {
            int next = map.get(x);
            map.put(x, parent);
            x = next;
        }
        return parent;
    }
    
    private void union(int x, int y, Map<Integer, Integer> map) {
        int fx = find(x, map);
        int fy = find(y, map);
        if(fx != fy) map.put(fy, fx);
    }
}