public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] bp = new int[amount + 1];
        Arrays.fill(bp, Integer.MAX_VALUE);
        bp[0] = 0;
        for(int i = 1; i <= amount; i++)
            for(int j : coins)
                if(i - j >= 0 && bp[i - j] != Integer.MAX_VALUE)
                    bp[i] = Math.min(bp[i], bp[i - j] + 1);
        return bp[amount] == Integer.MAX_VALUE ? -1 : bp[amount];
    }
}