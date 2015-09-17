public class Solution {
    public boolean isPalindrome(int x) {
        final int MAX_PALINDROME = 2147447412;
        if (x<0||x>MAX_PALINDROME) return false;
        if (x==reverse(x)) return true;
        else return false;
    }
    public int reverse(int x){
	    if(x<0)	return -reverse(-x);
	    int y = 0;
	    while(x>0){
	        y = y*10 + x%10;
	        x /= 10;
	    }
	    return y;
    }
}