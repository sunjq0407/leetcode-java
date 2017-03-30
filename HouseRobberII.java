public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] f = new int[2];
        f[0] = nums[0];
        f[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length - 1; i++)
            f[i%2] = Math.max(f[(i-1)%2], f[i%2] + nums[i]);
        int ret = f[(nums.length-2)%2];
        f[0] = 0;
        f[1] = nums[1];
        for(int i = 2; i < nums.length; i++)
            f[i%2] = Math.max(f[(i-1)%2], f[i%2] + nums[i]);
        return Math.max(ret, f[(nums.length-1)%2]);
    }
}