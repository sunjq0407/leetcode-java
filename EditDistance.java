public class Solution {
    public int minDistance(String word1, String word2) {
        int[][] f = new int[word1.length()+1][word2.length()+1];
        for(int i = 1; i <= word1.length(); i++) f[i][0] = i;
        for(int i = 1; i <= word2.length(); i++) f[0][i] = i;
        for(int i = 1; i <= word1.length(); i++) {
            for(int j = 1; j <= word2.length(); j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    f[i][j] = f[i-1][j-1];
                else f[i][j] = Math.min(f[i-1][j-1], Math.min(f[i-1][j], f[i][j-1])) + 1;
            }
        }
        return f[word1.length()][word2.length()];
    }
}