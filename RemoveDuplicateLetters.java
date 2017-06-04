public class Solution {
    public String removeDuplicateLetters(String s) {
        if(s.length() == 0) return "";
        int[] cnt = new int[26];
        int pos = 0;
        for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) pos = i;
            if (--cnt[s.charAt(i) - 'a'] == 0) break;
        }
        String str = s.substring(pos + 1).replaceAll("" + s.charAt(pos), "");
        return s.charAt(pos) + removeDuplicateLetters(str);
    }
}