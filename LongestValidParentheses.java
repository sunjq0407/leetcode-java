public class Solution {
    public int longestValidParentheses(String s) {
        int ret = 0;
        Stack<Integer> stack = new Stack<>();
        int start = -1;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') stack.push(i);
            else if(!stack.empty()) {
                stack.pop();
                if(stack.empty()) ret = Math.max(ret, i - start);
                else ret = Math.max(ret, i - stack.peek());
            } else start = i;
        }
        return ret;
    }
}