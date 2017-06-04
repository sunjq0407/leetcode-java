public class Solution {
    public int minCostII(int[][] costs) {
        if(costs.length == 0 || costs[0].length == 0) return 0;
        int[][] dp = new int[2][3];
        dp[0][0] = -1;
        for(int i = 1; i <= costs.length; i++) {
            dp[i%2][1] = Integer.MAX_VALUE;
            dp[i%2][2] = Integer.MAX_VALUE;
            for(int j = 0; j < costs[0].length; j++) {
                int cost = j == dp[(i-1)%2][0] ? dp[(i-1)%2][2] + costs[i-1][j] : dp[(i-1)%2][1] + costs[i-1][j];
                if(cost <= dp[i%2][1]) {
                    dp[i%2][2] = dp[i%2][1];
                    dp[i%2][1] = cost;
                    dp[i%2][0] = j;
                } else if(cost <= dp[i%2][2]) dp[i%2][2] = cost;
            }
        }
        return dp[costs.length%2][1];
    }
}