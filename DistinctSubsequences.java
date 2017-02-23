public class Solution {
    public int numDistinct(String s, String t) {
        if(t.length() == 0) return 1;
        if(s.length() == 0) return 0;
        int[][] f = new int[s.length()+1][t.length()+1];
        for(int i = 0; i <= s.length(); i++) f[i][0] = 1;
        for(int j = 1; j <= t.length(); j++) {
            for(int i = 1; i <= s.length(); i++) {
                f[i][j] = f[i - 1][j];
                if(s.charAt(i - 1) == t.charAt(j - 1)) f[i][j] += f[i - 1][j - 1];
            }
        }
        return f[s.length()][t.length()];
    }
}