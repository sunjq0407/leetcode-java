public class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Queue<Integer>> idMap = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(char c : t.toCharArray()) {
            idMap.put(c, new LinkedList<>());
            if(!map.containsKey(c)) map.put(c, 1);
            else map.put(c, map.get(c) + 1);
        }
        HashMap<Character, Integer> total = new HashMap<>(map);
        int min = Integer.MAX_VALUE;
        String ret = "";
        int hit = 0;
        int start = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) continue;
            set.add(i);
            idMap.get(c).offer(i);
            if(idMap.get(c).size() == total.get(c) + 1)
                set.remove(idMap.get(c).poll());
            while(!set.contains(start)) start++;
            if(map.get(c) > 0) {
                hit ++;
                map.put(c, map.get(c) - 1);
            }
            if(hit == t.length() && i - start + 1 < min) {
                min = i - start + 1;
                ret = s.substring(start, i + 1);
            }
        }
        return ret;
    }
}