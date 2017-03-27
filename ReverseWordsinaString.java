public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String str = "";
        int prev = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                str = s.substring(prev, i) + " " + str;
                while(i < s.length() && s.charAt(i) == ' ') i++;
                prev = i;
                i--;
            }
        }
        str = s.substring(prev, s.length()) + " " + str;
        return str.trim();
    }
}