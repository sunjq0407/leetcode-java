public class Solution {
    public int maxProduct(int[] nums) {
        int ret = nums[0];
        int max = nums[0];
        int min = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int max2 = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            int min2 = Math.min(nums[i], Math.min(max * nums[i], min * nums[i]));
            max = max2;
            min = min2;
            ret = Math.max(max, ret);
        }
        return ret;
    }
}