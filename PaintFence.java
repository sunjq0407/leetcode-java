public class Solution {
    public int numWays(int n, int k) {
        if(n == 0 || k == 0) return 0;
        if(n == 1) return k;
        int[] dp = new int[2];
        dp[0] = k;
        dp[1] = k * (k - 1);
        for(int i = 2; i < n; i++)
            dp[i%2] = (dp[i%2] + dp[(i-1)%2]) * (k - 1);
        return dp[0] + dp[1];
    }
}