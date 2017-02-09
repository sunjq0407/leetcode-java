public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;
        int i = s.length() - 1;
        int len = 0;
        for(; i >= 0; i--) {
            if(s.charAt(i) == ' ') break;
            else len++;
        }
        return len;
    }
}