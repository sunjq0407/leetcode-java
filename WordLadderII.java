public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ret = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        Set<String> passed = new HashSet<>();
        for(String str : wordList) set.add(str);
        boolean found = false;
        int len = 0;
        q.offer(beginWord);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String str = q.poll();
                if(passed.contains(str)) continue;
                if(!map.containsKey(str)) map.put(str, new ArrayList<>());
                for(String s : valid(str, set)) {
                    if(passed.contains(s)) continue;
                    if(s.equals(endWord)) found = true;
                    if(!map.containsKey(s)) map.put(s, new ArrayList<>());
                    map.get(s).add(str);
                    q.offer(s);
                }
                passed.add(str);
            }
            len ++;
            if(found) break;
        }
        List<String> list = new ArrayList<>();
        list.add(endWord);
        dfs(endWord, beginWord, 0, len, list, ret, map);
        return ret;
    }
    
    private void dfs(String str, String end, int len, int minLen, List<String> list,
            List<List<String>> ret, Map<String, List<String>> map) {
        if(len == minLen && str.equals(end)) {
            Collections.reverse(list);
            ret.add(new ArrayList<>(list));
            Collections.reverse(list);
            return;
        }
        if(len > minLen || !map.containsKey(str)) return;
        for(String s : map.get(str)) {
            list.add(s);
            dfs(s, end, len + 1, minLen, list, ret, map);
            list.remove(list.size() - 1);
        }
    }
    
    private Set<String> valid(String str, Set<String> set) {
        Set<String> ret = new HashSet<>();
        char[] arr = str.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            char tmp = arr[i];
            for(char c = 'a'; c <= 'z'; c++) {
                if(c == tmp) continue;
                arr[i] = c;
                if(set.contains(String.valueOf(arr)))
                    ret.add(String.valueOf(arr));
                arr[i] = tmp;
            }
        }
        return ret;
    }
}