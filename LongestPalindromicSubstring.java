public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len <= 1) return s;
        char[] charArray = s.toCharArray();
        int maxLen = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int i = 0;
        while(i < len){
            int next = len - 1;
            for(int j = i+1; j < len; j++) {
                if(charArray[j] != charArray[i]) {
                    next = j-1;
                    break;
                }
            }
            int left = i;
            int right = next;
            while(left - 1 >= 0 && right + 1 < len){
                if(charArray[left - 1] == charArray[right + 1]){
                    left--;
                    right++;
                } else break;
            }
            int length = right - left;
            if(length > maxLen){
                maxLen = length;
                maxLeft = left;
                maxRight = right;
            }
            i = next + 1;
        }
        return s.substring(maxLeft, maxRight + 1);
    }
}