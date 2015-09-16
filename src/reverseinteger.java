import java.util.*;
class Solution {
	public int reverse(int x) {
		if(x == Integer.MIN_VALUE) return 0;
	    if(x<0)	return -reverse(-x);
	    int y = 0;
	    while(x>0){
	    	if(y > (Integer.MAX_VALUE - x % 10) / 10)
	    		return 0;
	        y *= 10;
	        y += x%10;
	        x /= 10;
	    }
	    return y;
    }
}
public class reverseinteger{
    public static void main(String[] args){
    	Solution solution = new Solution();
    	int[] a = {12345, Integer.MIN_VALUE, Integer.MAX_VALUE};
        int[] b = a;
		for(int i=0; i<a.length; i++) {
			b[i] = solution.reverse(a[i]);
			System.out.println (b[i]);
		}
	}
}