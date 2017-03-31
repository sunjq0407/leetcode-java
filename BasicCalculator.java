public class Solution {
    public int calculate(String s) {
        Stack<Integer> num = new Stack<>();
        Stack<Boolean> plus = new Stack<>();
        num.push(0);
        plus.push(true);
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                int n = c - '0';
                while(++i < s.length() && Character.isDigit(s.charAt(i)))
                    n = n * 10 - '0' + s.charAt(i);
                i--;
                if(plus.pop()) num.push(num.pop() + n);
                else num.push(num.pop() - n);
            }
            else if(c == '+') plus.push(true);
            else if(c == '-') plus.push(false);
            else if(c == '(') {
                while(!Character.isDigit(s.charAt(i))) i++;
                int n = s.charAt(i) - '0';
                while(++i < s.length() && Character.isDigit(s.charAt(i)))
                    n = n * 10 - '0' + s.charAt(i);
                i--;
                num.push(n);
            }
            else if(c == ')') {
                if(plus.pop()) num.push(num.pop() + num.pop());
                else num.push(-num.pop() + num.pop());
            }
        }
        return num.pop();
    }
}