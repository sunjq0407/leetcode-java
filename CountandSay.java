public class Solution {
    public String countAndSay(int n) {
        return helper("1", n);
    }
    
    private String helper(String str, int n) {
        if(n == 1) return str;
        String ret = "";
        for(int i = 0; i < str.length(); i++) {
            int cnt = 1;
            while(i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                i ++;
                cnt ++;
            }
            ret += cnt;
            ret += str.charAt(i);
        }
        return helper(ret, n - 1);
    }
}