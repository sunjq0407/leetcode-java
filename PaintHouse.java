public class Solution {
    public int minCost(int[][] costs) {
        if(costs.length == 0) return 0;
        int[][] dp = new int[2][3];
        for(int i = 0; i < 3; i++) dp[0][i] = costs[0][i];
        for(int i = 1; i < costs.length; i++) {
            dp[i%2][0] = costs[i][0] + Math.min(dp[(i-1)%2][1], dp[(i-1)%2][2]);
            dp[i%2][1] = costs[i][1] + Math.min(dp[(i-1)%2][0], dp[(i-1)%2][2]);
            dp[i%2][2] = costs[i][2] + Math.min(dp[(i-1)%2][0], dp[(i-1)%2][1]);
        }
        return Math.min(dp[(costs.length-1)%2][0],
                Math.min(dp[(costs.length-1)%2][1], dp[(costs.length-1)%2][2]));
    }
}