public class Solution {
    public boolean isMatch(String s, String p) {
        return helper(s.toCharArray(), p.toCharArray(), 0, 0, 0, -1);
    }
    
    private boolean helper(char[] s, char[] p, int i, int j, int lastS, int lastP) {
        if(i == s.length && j == p.length) return true;
        if(j < p.length) {
            if(i == s.length)
                return p[j] == '*' ? helper(s, p, i, j + 1, lastS, lastP) : false;
            if(p[j] == '?' || s[i] == p[j])
                return helper(s, p, i + 1, j + 1, lastS, lastP);
            if(p[j] == '*')
                return helper(s, p, i, j + 1, i, j);
        }
        if(lastP != -1) return helper(s, p, lastS + 1, lastP, lastS + 1, lastP);
        return false;
    }
}