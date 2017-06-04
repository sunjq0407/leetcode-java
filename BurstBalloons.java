public class Solution {
    public int maxCoins(int[] nums) {
        if(nums.length == 0) return 0;
        int[][] f = new int[nums.length][nums.length];
        for(int len = 0; len < nums.length; len++) {
            for(int i = 0; i + len < nums.length; i++) {
                for(int j = i; j <= i + len; j++) {
                    int coin = nums[j];
                    coin *= i - 1 >= 0 ? nums[i - 1] : 1;
                    coin *= i + len + 1 < nums.length ? nums[i + len + 1] : 1;
                    if(j != i) coin += f[i][j - 1];
                    if(j != i + len) coin += f[j + 1][i + len];
                    f[i][i + len] = Math.max(f[i][i + len], coin);
                }
            }
        }
        return f[0][nums.length - 1];
    }
}