public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s.equals(t) || Math.abs(s.length() - t.length()) > 1) return false;
        boolean diff = false;
        if(s.length() == t.length()) {
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) != t.charAt(i)) {
                    if(diff) return false;
                    diff = true;
                }
            }
            return true;
        }
        if(s.length() > t.length()) {
            String tmp = s;
            s = t;
            t = tmp;
        }
        int j = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != t.charAt(j++)) {
                if(diff) return false;
                diff = true;
                i--;
            }
        }
        return true;
    }
}