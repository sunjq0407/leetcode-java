public class Solution {
    
    private class Node {
        char c;
        int val;
        List<Node> neighbors;
        public Node(char c) {
            this.c = c;
            val = 0;
            neighbors = new ArrayList<>();
        }
    }
    
    public String alienOrder(String[] words) {
        Map<Character, Node> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            for(char c : words[i].toCharArray())
                if(!map.containsKey(c)) map.put(c, new Node(c));
            if(i == words.length - 1) break;
            for(int j = 0; j < Math.min(words[i].length(), words[i + 1].length()); j++) {
                if(words[i].charAt(j) != words[i + 1].charAt(j)) {
                    Node node = map.get(words[i].charAt(j));
                    char c = words[i + 1].charAt(j);
                    if(!map.containsKey(c)) map.put(c, new Node(c));
                    Node neighbor = map.get(words[i + 1].charAt(j));
                    node.neighbors.add(neighbor);
                    neighbor.val++;
                    break;
                }
            }
        }
        Queue<Node> q = new LinkedList<>();
        String ret = "";
        for(char c : map.keySet()) {
            if(map.get(c).val == 0) {
                q.offer(map.get(c));
                ret += c;
            }
        }
        while(!q.isEmpty()) {
            Node node = q.poll();
            for(Node n : node.neighbors) {
                n.val--;
                if(n.val == 0) {
                    q.offer(n);
                    ret += n.c;
                }
            }
        }
        for(char c : map.keySet()) if(map.get(c).val != 0) return "";
        return ret;
    }
}