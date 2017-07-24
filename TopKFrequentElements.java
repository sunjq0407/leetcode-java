public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(
            k, new Comparator<Map.Entry<Integer, Integer>>() {
                public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                    return e1.getValue() - e2.getValue();
                }
            });
        for(int i : nums) {
            if(!map.containsKey(i)) map.put(i, 1);
            else map.put(i, map.get(i) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(pq.size() < k) pq.offer(entry);
            else if(pq.peek().getValue() < entry.getValue()) {
                pq.poll();
                pq.offer(entry);
            }
        }
        List<Integer> ret = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : pq)
            ret.add(entry.getKey());
        return ret;
    }
}