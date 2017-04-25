public class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        int id = 0;
        for(char c : pattern.toCharArray()) {
            if(id >= str.length()) return false;
            int prev = id;
            for(; id < str.length(); id++)
                if(str.charAt(id) == ' ') break;
            String word = str.substring(prev, id++);
            if(map.containsKey(c) && !map.get(c).equals(word)) return false;
            if(!map.containsKey(c) && set.contains(word)) return false;
            map.put(c, word);
            set.add(word);
        }
        return id >= str.length();
    }
}