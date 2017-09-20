class Solution {
    public int longestSubstring(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) < k) {
                list.add(i);
            }
        }
        if(list.size() == 1) {
            return s.length();
        }
        list.add(s.length());
        int ret = 0;
        for(int i = 0; i < list.size() - 1; i++) {
            ret = Math.max(ret, longestSubstring(s.substring(list.get(i) + 1, list.get(i + 1)), k));
        }
        return ret;
    }
}