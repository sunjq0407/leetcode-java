public class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();
        String[] strs = preorder.split(",");
        for(String str : strs) {
            while(str.equals("#") && !stack.empty() && stack.peek().equals("#")) {
                stack.pop();
                if(stack.empty()) return false;
                stack.pop();
            }
            stack.push(str);
        }
        return stack.size() == 1 && stack.pop().equals("#");
    }
}