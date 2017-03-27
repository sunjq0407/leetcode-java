public class Solution {
    public int trailingZeroes(int n) {
        int ret = 0;
        long de = 5;
        while(n >= de) {
            ret += n / de;
            de *= 5;
        }
        return ret;
    }
}