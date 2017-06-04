public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return helper(pattern, str, 0, 0, map, set);
    }
    
    private boolean helper(String pattern, String str, int pid, int sid,
            Map<Character, String> map, Set<String> set) {
        if(pid == pattern.length()) return sid == str.length();
        char c = pattern.charAt(pid);
        if(map.containsKey(c)) {
            if(str.length() >= sid + map.get(c).length()
                    && str.substring(sid, sid + map.get(c).length()).equals(map.get(c)))
                return helper(pattern, str, pid + 1, sid + map.get(c).length(), map, set);
            else return false;
        }
        for(int i = sid + 1; i <= str.length(); i++) {
            String word = str.substring(sid, i);
            if(set.contains(word)) continue;
            map.put(c, word);
            set.add(word);
            if(helper(pattern, str, pid + 1, i, map, set)) return true;
            set.remove(word);
            map.remove(c);
        }
        return false;
    }
}