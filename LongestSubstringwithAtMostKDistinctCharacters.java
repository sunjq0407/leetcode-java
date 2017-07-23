public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s.length() == 0 || k == 0) return 0;
        int ret = 0;
        int start = 0;
        TreeMap<Integer, Character> tm = new TreeMap<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.size() == k && !map.containsKey(c)) {
                char evict = tm.pollFirstEntry().getValue();
                start = map.get(evict) + 1;
                map.remove(evict);
            }
            if(map.containsKey(c)) tm.remove(map.get(c));
            map.put(c, i);
            tm.put(i, c);
            ret = Math.max(ret, i - start + 1);
        }
        return ret;
    }
}