public class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == 0) return 0;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        boolean neg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        int ret = 0;
        long mlt = 1;
        while(dvd >= dvs) {
            dvs <<= 1;
            mlt <<= 1;
        }
        dvs >>= 1;
        mlt >>= 1;
        while(dvs > 0) {
            if(dvd >= dvs) {
                dvd -= dvs;
                ret += mlt;
            } else {
                dvs >>= 1;
                mlt >>= 1;
            }
        }
        return neg ? -ret : ret;
    }
}