public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean dot = false;
        boolean e = false;
        boolean numLeft = false;
        boolean numRight = false;
        if(s.length() == 0) return false;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '+' || c == '-') {
                if(i == 0 || (i > 0 && s.charAt(i - 1) == 'e'))
                    continue;
                else return false;
            }
            else if(c >= '0' && c <= '9') {
                if(!e) numLeft = true;
                else if(e) numRight = true;
            }
            else if(c == '.') {
                if(dot || e) return false;
                dot = true;
            } else if(c == 'e') {
                if(e || !numLeft) return false;
                e = true;
            }
            else return false;
        }
        if(e) return numRight;
        if(dot) return s.length() > 1 && !s.equals("-.");
        return true;
    }
}