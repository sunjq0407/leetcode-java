public class Solution {
    public int minCut(String s) {
        boolean[][] valid = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) valid[i][i] = true;
        for(int i = 0; i < s.length() - 1; i++)
            valid[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        for(int i = 2; i < s.length(); i++)
            for(int j = 0; j + i < s.length(); j++)
                valid[j][j + i] = s.charAt(j) == s.charAt(j + i) && valid[j + 1][j + i - 1];
        int[] f = new int[s.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            f[i] = i;
            for (int j = 0; j < i; j++) {
                if (valid[j][i - 1])
                    f[i] = Math.min(f[i], f[j] + 1);
            }
        }
        return f[s.length()] - 1;
    }
}