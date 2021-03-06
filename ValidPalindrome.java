public class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        int left = 0;
        int right = str.length() - 1;
        while(left < right) {
            if(!Character.isLetterOrDigit(str.charAt(left))) {
                left++;
                continue;
            }
            if(!Character.isLetterOrDigit(str.charAt(right))) {
                right--;
                continue;
            }
            if(str.charAt(left) != str.charAt(right)) return false;
            left ++;
            right --;
        }
        return true;
    }
}