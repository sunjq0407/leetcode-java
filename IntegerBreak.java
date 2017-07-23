public class Solution {
    public int integerBreak(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        int[] f = new int[n + 1];
        f[1] = 1;
        f[2] = 2;
        f[3] = 3;
        return helper(n, f);
    }
    
    private int helper(int n, int[] f) {
        if(f[n] != 0) return f[n];
        for(int i = 2; i <= n / 2; i++)
            f[n] = Math.max(f[n], helper(i, f) * helper(n - i, f));
        return f[n];
    }
}