public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String str : tokens) {
            if(str.equals("+")) stack.push(stack.pop() + stack.pop());
            else if(str.equals("-")) {
                int i = stack.pop();
                stack.push(stack.pop() - i);
            } else if(str.equals("*")) stack.push(stack.pop() * stack.pop());
            else if(str.equals("/")) {
                int i = stack.pop();
                stack.push(stack.pop() / i);
            } else stack.push(Integer.parseInt(str));
        }
        return stack.pop();
    }
}