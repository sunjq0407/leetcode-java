public class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        String ret = "";
        int i = 0;
        while(i < s.length()) {
            int j = i;
            for(; j < s.length(); j++)
                if(s.charAt(j) != s.charAt(i)) break;
            int next = j;
            int l = i;
            int r = j - 1;
            while(l >= 0 && r < s.length()
                    && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            l++;
            r--;
            if(r - l > ret.length() - 1)
                ret = s.substring(l, r + 1);
            i = next;
        }
        return ret;
    }
}