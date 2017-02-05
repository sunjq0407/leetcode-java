public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();
        int n = words.length;
        if(s == null || s.length() == 0 || n == 0) return ret;
        HashMap<String, Integer> map = new HashMap<>();
        for(String str : words)
            map.put(str, map.containsKey(str) ? map.get(str) + 1 : 1);
        int len = words[0].length();
        for(int i = 0; i <= s.length() - len * n; i++) {
            HashMap<String, Integer> cur = new HashMap<>(map);
            int j = i;
            while(j < i + len * n) {
                String str = s.substring(j, j + len);
                if(cur.containsKey(str)) {
                    if(cur.get(str) == 1) cur.remove(str);
                    else cur.put(str, cur.get(str) - 1);
                    j += len;
                    if(cur.isEmpty()) {
                        ret.add(i);
                        break;
                    }
                } else break;
            }
        }
        return ret;
    }
}