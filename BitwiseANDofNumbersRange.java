public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int f = 1;
        while(m != n) {
            m >>>= 1;
            n >>>= 1;
            f <<= 1;
        }
        return m * f;
    }
}