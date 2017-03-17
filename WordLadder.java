public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String str : wordList) set.add(str);
        Queue<String> q = new LinkedList<>();
        int len = 1;
        q.offer(beginWord);
        while(!q.isEmpty()) {
            int size = q.size();
            len ++;
            for(int i = 0; i < size; i++) {
                String str = q.poll();
                Set<String> copy = new HashSet<>(set);
                for(String s : valid(str, set)) {
                    if(s.equals(endWord)) return len;
                    q.offer(s);
                    copy.remove(s);
                }
                set = copy;
            }
        }
        return 0;
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