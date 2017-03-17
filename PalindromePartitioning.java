public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<>();
        boolean[][] valid = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) valid[i][i] = true;
        for(int i = 0; i < s.length() - 1; i++)
            valid[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        for(int i = 2; i < s.length(); i++)
            for(int j = 0; j + i < s.length(); j++)
                valid[j][j + i] = s.charAt(j) == s.charAt(j + i) && valid[j + 1][j + i - 1];
        helper(s, 0, valid, new ArrayList<>(), ret);
        return ret;
    }
    
    private void helper(String s, int idx, boolean[][] valid, 
            List<String> list, List<List<String>> ret) {
        if(idx == s.length()) {
            ret.add(new ArrayList<>(list));
            return;
        }
        for(int i = idx; i < s.length(); i++) {
            if(valid[idx][i]) {
                list.add(s.substring(idx, i + 1));
                helper(s, i + 1, valid, list, ret);
                list.remove(list.size() - 1);
            }
        }
    }
}