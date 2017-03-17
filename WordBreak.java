public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(String str : wordDict) {
            min = Math.min(min, str.length());
            max = Math.max(max, str.length());
            dict.add(str);
        }
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = Math.max(0, i - max); j <= Math.max(0, i - min); j++) {
                if(f[j] && dict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
}