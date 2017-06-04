public class Solution {
    public void reverseWords(char[] s) {
        if(s.length == 0) return;
        helper(s, 0);
    }
    
    private void helper(char[] s, int start) {
        String str = "";
        int i = s.length - 1;
        for(; i >= start; i--)
            if(s[i] != ' ') str = s[i] + str;
            else break;
        if(i == start - 1) return;
        str += " ";
        int offset = str.length();
        for(int j = s.length - 1 - offset; j >= start; j--)
            s[j + offset] = s[j];
        for(int j = 0; j < offset; j++)
            s[j + start] = str.charAt(j);
        helper(s, start + offset);
    }
}