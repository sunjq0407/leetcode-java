public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        helper(0, n, 0, ret, "");
        return ret;
    }
    
    private void helper(int i, int n, int level, List<String> ret, String str) {
        if(i == n) {
            for(int j = level; j > 0; j--) str += ')';
            ret.add(str);
            return;
        }
        if(level > 0) helper(i, n, level - 1, ret, str + ')');
        helper(i + 1, n, level + 1, ret, str + '(');
    }
}