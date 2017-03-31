public class Solution {
    public int countDigitOne(int n) {
        int ret = 0;
        for (long m = 1; m <= n; m *= 10)
            ret += (n / m + 8) / 10 * m + (n / m % 10 == 1 ? n % m + 1 : 0);
        return ret;
    }
}