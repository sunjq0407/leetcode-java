class Solution {
    
    private static final int BASE = 1337;
    
    public int superPow(int a, int[] b) {
        return helper(a, b, b.length - 1);
    }
    
    private int helper(int a, int[] b, int idx) {
        if(idx < 0) {
            return 1;
        }
        return powMod(helper(a, b, idx - 1), 10) * powMod(a, b[idx]) % BASE;
    }
    
    private int powMod(int a, int b) {
        a %= BASE;
        int ret = 1;
        for(int i = 0; i < b; i++) {
            ret = ret * a % BASE;
        }
        return ret;
    }
}