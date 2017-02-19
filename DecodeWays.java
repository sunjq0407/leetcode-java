public class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        int[] f = new int[s.length() + 1];
        f[s.length()] = 1;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == '0') {
                f[i] = 0;
                continue;
            }
            f[i] = f[i + 1];
            if(i + 1 < s.length() && (s.charAt(i) == '1'
                    || (s.charAt(i) == '2' && s.charAt(i + 1) >= '0'
                    && s.charAt(i + 1) <= '6')))
                f[i] += f[i + 2];
        }
        return f[0];
    }
}