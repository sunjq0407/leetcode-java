class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        for(; i < num.length() && k > 0; i++) {
            if(stack.empty()) {
                stack.push(num.charAt(i));
            } else if(stack.peek() > num.charAt(i)) {
                while(!stack.empty() && stack.peek() > num.charAt(i) && k > 0) {
                    stack.pop();
                    k --;
                }
                stack.push(num.charAt(i));
            } else {
                stack.push(num.charAt(i));
            }
        }
        while(k > 0) {
            stack.pop();
            k --;
        }
        String suffix = "";
        if(i != num.length()) {
            suffix = num.substring(i);
        }
        StringBuilder sb = new StringBuilder(suffix);
        while(!stack.empty()) {
            sb.insert(0, stack.pop());
        }
        while(sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}