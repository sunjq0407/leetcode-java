import java.util.*;

class Solution{
    public int reverse(int x) {
        if(x<0)
        	return -reverse(-x);
        int y = 0;
        while(x!=0){
        	y *= 10;
        	y += x%10;
        	x = x/10;
        }
        return y;
    }
    int a = 12345;
    int b = this.reverse(a);
}
public class reverseinteger{
    public static void main(String[] args){
    	Solution solution = new Solution();
		System.out.println (solution.b);
	}
}