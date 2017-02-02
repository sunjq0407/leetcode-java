public class Solution {
    public boolean isMatch(String s, String p) {
        return helper(s.toCharArray(), p.toCharArray(), 0, 0);
    }
    
    private boolean helper(char[] a, char[] b, int i, int j) {
        if(i == a.length && j == b.length) return true;
        if(i == a.length) {
            while(j + 1 < b.length && b[j + 1] == '*') {
                if(helper(a, b, i, j + 2)) return true;
                j = j + 2;
            }
            return false;
        }
        if(j == b.length) return false;
        if((j + 1 < b.length && b[j + 1] != '*') || j == b.length - 1)
            return (b[j] == '.' || a[i] == b[j]) && helper(a, b, i + 1, j + 1);
        if(helper(a, b, i, j + 2)) return true;
        while(a[i] == b[j] || b[j] == '.') {
            if(++i == a.length && j + 2 == b.length) return true;
            if(helper(a, b, i, j + 2)) return true;
            if(i == a.length) return false;
        }
        return false;
    }
}