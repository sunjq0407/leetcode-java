/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()) {
            UndirectedGraphNode cur = q.poll();
            if(!set.contains(cur)) {
                set.add(cur);
                map.put(cur, new UndirectedGraphNode(cur.label));
            }
            for(UndirectedGraphNode nb : cur.neighbors)
                if(!set.contains(nb)) q.offer(nb);
        }
        for(UndirectedGraphNode cur : set)
            for(UndirectedGraphNode nb : cur.neighbors)
                map.get(cur).neighbors.add(map.get(nb));
        return map.get(node);
    }
}