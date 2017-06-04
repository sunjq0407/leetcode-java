public class Solution {
    public boolean isStrobogrammatic(String num) {
        for(int i = 0; i < num.length() / 2; i++)
            if(!helper(num.charAt(i), num.charAt(num.length() - 1 - i)))
                return false;
        if(num.length() % 2 == 1) {
            char c = num.charAt(num.length() / 2);
            return c == '1' || c == '8' || c == '0';
        }
        return true;
    }
    
    private boolean helper(char a, char b) {
        return (a == '1' && b == '1') || (a == '6' && b == '9')
                || (a == '8' && b == '8') || (a == '9' && b == '6')
                || (a == '0' && b == '0');
    }
}