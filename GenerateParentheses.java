public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        helper(n, 0, "", result);
        return result;
    }
    
    private void helper(int n, int count, String str, List<String> result) {
        if(n == 0) {
            while(count-- > 0) str += ')';
            result.add(str);
        }
        else {
            helper(n - 1, count + 1, str + '(', result);
            if(count > 0) helper(n, count - 1, str + ')', result);
        }
    }
}