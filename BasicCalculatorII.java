public class Solution {
    public int calculate(String s) {
        int num = 0;
        int cur = 0;
        boolean plus = true;
        char mult = '#';
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                int n = c - '0';
                while(++i < s.length() && Character.isDigit(s.charAt(i)))
                    n = n * 10 - '0' + s.charAt(i);
                i--;
                if(mult == '*') {
                    cur *= n;
                    mult = '#';
                } else if(mult == '/') {
                    cur /= n;
                    mult = '#';
                } else cur = n;
            } else if(c == '+') {
                num += plus ? cur : -cur;
                plus = true;
            }
            else if(c == '-') {
                num += plus ? cur : -cur;
                plus = false;
            }
            else if(c == '*') mult = '*';
            else if(c == '/') mult = '/';
        }
        if(mult == '*') return num * cur;
        if(mult == '/') return num / cur;
        return plus ? num + cur : num - cur;
    }
}