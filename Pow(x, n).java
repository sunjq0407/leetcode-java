public class Solution {
    public double myPow(double x, int n) {
        if(x == 1) return 1;
        if(n == Integer.MIN_VALUE) {
            if(x == -1) return 1;
            return 0;
        }
        boolean neg = n < 0;
        if(neg) n = -n;
        double ret = 1;
        while(n > 0) {
            if(n % 2 == 1)
                ret = neg ? ret / x : ret * x;
            x *= x;
            n >>= 1;
        }
        return ret;
    }
}