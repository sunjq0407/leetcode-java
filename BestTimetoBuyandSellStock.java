public class Solution {
    public int maxProfit(int[] prices) {
        int ret = 0;
        if(prices.length <= 1) return 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++) {
            ret = Math.max(ret, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return ret;
    }
}