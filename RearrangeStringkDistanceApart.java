public class Solution {
    
    private class Elem {
        char c;
        int cnt;
        public Elem(char c, int cnt) {
            this.c = c;
            this.cnt = cnt;
        }
    }
    
    public String rearrangeString(String s, int k) {
        Map<Character, Elem> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            if(!map.containsKey(c)) map.put(c, new Elem(c, 1));
            else map.get(c).cnt ++;
        }
        PriorityQueue<Elem> pq = new PriorityQueue<>((e1, e2) -> e2.cnt - e1.cnt);
        for(Elem e : map.values()) {
            pq.offer(e);
        }
        StringBuilder sb = new StringBuilder();
        LinkedList<Elem> list = new LinkedList<>();
        while(!pq.isEmpty()) {
            Elem e = pq.poll();
            if(e.cnt == 0) {
                break;
            }
            sb.append(e.c);
            e.cnt --;
            if(e.cnt >= 0) {
                list.offer(e);
                if(list.size() >= k) {
                    pq.offer(list.poll());
                }
            }
        }
        return sb.length() == s.length() ? sb.toString() : "";
    }
}