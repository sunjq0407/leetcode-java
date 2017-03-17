public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(String str : wordDict) {
            min = Math.min(min, str.length());
            max = Math.max(max, str.length());
            dict.add(str);
        }
        boolean[][] valid = new boolean[s.length()][s.length()];
        for(int i = 0; i <= s.length() - min; i++)
            for(int j = i + min; j <= Math.min(i + max, s.length()); j++)
                valid[i][j - 1] = dict.contains(s.substring(i, j));
        boolean[] f = new boolean[s.length() + 1];
        f[s.length()] = true;
        for(int i = s.length() - min; i >= 0; i--) {
            for(int j = i + min; j <= Math.min(i + max, s.length()); j++) {
                if(valid[i][j - 1] && f[j]) {
                    f[i] = true;
                    break;
                }
            }
        }
        List<String> ret = new ArrayList<>();
        helper(s, 0, valid, f, "", ret, min, max);
        return ret;
    }
    
    private void helper(String s, int idx, boolean[][] valid, boolean[] f,
            String str, List<String> ret, int min, int max) {
        if(idx == s.length()) {
            ret.add(str.substring(0, str.length() - 1));
            return;
        }
        for(int i = Math.min(idx + min, s.length());
                i <= Math.min(idx + max, s.length()); i++)
            if(valid[idx][i - 1] && f[i])
                helper(s, i, valid, f, str + s.substring(idx, i) + " ", ret, min, max);
    }
}