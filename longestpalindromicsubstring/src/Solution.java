public class Solution {
    public String longestPalindrome(String s) {
        int start = 0, len = 0, i = 0, tmp = 0;
        while (i<s.length()) {
            tmp = Math.max(iscenter(i,i,s),iscenter(i,i+1,s));
            if (tmp>len) {
                len = tmp;
                start = i-(len+len%2)/2+1;
            }
            i++;
        }
        return s.substring(start, start+len);
    }
    private int iscenter(int i, int j, String s) {
        int offset = 0;
        while (j+offset<s.length()&&i-offset>=0
               &&s.charAt(i-offset)==s.charAt(j+offset)) offset++;
        if (i==j) return 2*offset-1;
        else return 2*offset;
    }
}