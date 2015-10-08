public class Solution {
    public int divide(int dividend, int divisor) {
        int ret = 0, shift = 1;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == Integer.MIN_VALUE) return 1;
            else if (divisor == 1) return Integer.MIN_VALUE;
            else if (divisor == -1) return Integer.MAX_VALUE;
            else if (divisor > 1) {
                dividend += divisor;
                ret ++;
            }
            else if (divisor < 1) {
                dividend -= divisor;
                ret ++;
            }
        }
        if (divisor == Integer.MIN_VALUE) return 0;
        boolean neg = false;
        if ((dividend>0&&divisor<0)||(dividend<0&&divisor>0)) neg = true;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while (dividend>=divisor&&divisor>0) {
            ret += shift;
            dividend -= divisor;
            divisor <<= 1;
            shift <<= 1;
        }
        while (shift>0&&divisor>0) {
            if (dividend>=divisor) {
                ret += shift;
                dividend -= divisor;
            }
            else {
                divisor >>= 1;
                shift >>= 1;
            }
        }
        if (neg) return -ret;
        else return ret;
    }
}