public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> ret = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        boolean odd = false;
        String mid = "";
        for(char c : map.keySet()) {
            if(map.get(c) % 2 != 0) {
                if(odd) return ret;
                odd = true;
                mid += c;
                map.put(c, (map.get(c) - 1) / 2);
            } else map.put(c, map.get(c) / 2);
        }
        helper("", s.length() / 2, map, mid, ret);
        return ret;
    }
    
    private void helper(String str, int length,
            Map<Character, Integer> map, String mid, List<String> list) {
        if(str.length() == length) {
            list.add(str + mid + new StringBuilder(str).reverse());
            return;
        }
        for(char c : map.keySet()) {
            if(map.get(c) != 0) {
                map.put(c, map.get(c) - 1);
                helper(str + c, length, map, mid, list);
                map.put(c, map.get(c) + 1);
            }
        }
    }
}