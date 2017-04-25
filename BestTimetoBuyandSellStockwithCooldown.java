public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int[] buy = new int[2];
        int[] sell = new int[2];
        buy[0] = -prices[0];
        for(int i = 1; i < prices.length; i++) {
            buy[i%2] = Math.max(buy[(i-1)%2], sell[i%2] - prices[i]);
            sell[i%2] = Math.max(sell[(i-1)%2], buy[(i-1)%2] + prices[i]);
        }
        return sell[(prices.length-1)%2];
    }
}