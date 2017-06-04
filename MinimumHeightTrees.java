public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) {
            List<Integer> ret = new ArrayList<>();
            ret.add(0);
            return ret;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] edge : edges) {
            if(!map.containsKey(edge[0])) map.put(edge[0], new HashSet<>());
            if(!map.containsKey(edge[1])) map.put(edge[1], new HashSet<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        List<Integer> list = new ArrayList<>();
        for(int i : map.keySet()) if(map.get(i).size() == 1) list.add(i);
        while(n > 2) {
            n -= list.size();
            List<Integer> newList = new ArrayList<>();
            for(int i : list) {
                for(int j : map.get(i)) {
                    map.get(j).remove(i);
                    if(map.get(j).size() == 1) newList.add(j);
                }
            }
            list = newList;
        }
        return list;
    }
}