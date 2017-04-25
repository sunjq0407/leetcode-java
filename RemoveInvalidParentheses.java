public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int rml = 0;
        int rmr = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') rml++;
            else if(c == ')') {
                if(rml > 0) rml--;
                else rmr++;
            }
        }
        Set<String> ret = new HashSet<>();
        dfs(s, 0, "", rml, rmr, 0, ret);
        return new ArrayList<>(ret);
    }
    
    private void dfs(String s, int i, String str, int rml, int rmr, int cnt, Set<String> ret) {
        if(rml < 0 || rmr < 0 || cnt < 0) return;
        if(i == s.length()) {
            if(rml == 0 && rmr == 0 && cnt == 0) ret.add(str);
            return;
        }
        if(s.charAt(i) == '(') {
            dfs(s, i + 1, str + '(', rml, rmr, cnt + 1, ret);
            dfs(s, i + 1, str, rml - 1, rmr, cnt, ret);
        } else if(s.charAt(i) == ')') {
            dfs(s, i + 1, str + ')', rml, rmr, cnt - 1, ret);
            dfs(s, i + 1, str, rml, rmr - 1, cnt, ret);
        } else dfs(s, i + 1, str + s.charAt(i), rml, rmr, cnt, ret);
    }
}