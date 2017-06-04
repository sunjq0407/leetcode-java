public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        for(int i : preorder) {
            if(i <= min) return false;
            if(stack.empty() || i < stack.peek()) stack.push(i);
            else if(i == stack.peek()) return false;
            else {
                while(!stack.empty() && i > stack.peek()) min = stack.pop();
                stack.push(i);
            }
        }
        return true;
    }
}