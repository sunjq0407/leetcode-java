public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        LinkedList<String> ret = new LinkedList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(String[] strs : tickets) {
            map.putIfAbsent(strs[0], new PriorityQueue<>());
            map.get(strs[0]).add(strs[1]);
        }
        dfs("JFK", map, ret);
        return ret;
    }
    
    private void dfs(String str, Map<String, PriorityQueue<String>> map, LinkedList<String> ret) {
        while(map.containsKey(str) && map.get(str).size() != 0)
            dfs(map.get(str).poll(), map, ret);
        ret.addFirst(str);
    }
}