public class Solution {
    public int myAtoi(String str) {
        if(str == null || "".equals(str)) return 0;
        str = str.trim();
        if(str.charAt(0)==' ') return 0;
        else if (str.charAt(0)=='-'||str.charAt(0)=='+'){
            if (str.length()>=2&&(str.charAt(1)<'0'||str.charAt(1)>'9'))
                return 0;
        }
        else if (str.charAt(0)<'0'||str.charAt(0)>'9') return 0;
        String s = "";
        int i;
        for(i=0; i<str.length(); i++){
            if((str.charAt(i)<'0'||str.charAt(i)>'9')
               &&str.charAt(i)!='-'&&str.charAt(i)!='+') break;
            else s += str.charAt(i);
        }
        if(i>11){
            if(str.charAt(0)=='-') return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }
        Long ret = Long.parseLong(s);
        if (ret>=Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (ret<=Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return Integer.parseInt(s);
    }
}