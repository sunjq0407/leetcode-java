public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<Character>();
        int start = 0, length = 0;
        for(int i=0; i<s.length(); i++) {
            if(set.contains(s.charAt(i))) {
                length = Math.max(length, i-start);
                while (start < i && s.charAt(start) != s.charAt(i))
                    set.remove(s.charAt(start++));
                start ++;
            }
            set.add(s.charAt(i));
        }
        return Math.max(length, s.length() - start);
    }
}