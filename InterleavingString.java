public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        boolean[][] f = new boolean[s1.length()+1][s2.length()+1];
        f[0][0] = true;
        for(int i = 1; i <= s1.length(); i++)
            f[i][0] = s3.charAt(i - 1) == s1.charAt(i - 1) && f[i - 1][0];
        for(int i = 1; i <= s2.length(); i++)
            f[0][i] = s3.charAt(i - 1) == s2.charAt(i - 1) && f[0][i - 1];
        for(int i = 1; i <= s1.length(); i++) {
            for(int j = 1; j <= s2.length(); j++) {
                f[i][j] = s3.charAt(i + j - 1) == s1.charAt(i - 1) && f[i - 1][j]
                        || s3.charAt(i + j - 1) == s2.charAt(j - 1) && f[i][j - 1];
            }
        }
        return f[s1.length()][s2.length()];
    }
}