public class Solution {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        boolean[][][] f = new boolean[n][n][n+1];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                f[i][j][1] = s1.charAt(i) == s2.charAt(j);
        for(int len = 2; len <= n; len++)
            for(int i = 0; i+len <= n; i++)
                for(int j = 0; j+len <= n; j++)
                    for(int k = 1; k < len; k++)
                        f[i][j][len] |= f[i][j][k] && f[i+k][j+k][len-k]
                                || f[i][j+len-k][k] && f[i+k][j][len-k];
        return f[0][0][n];
    }
}