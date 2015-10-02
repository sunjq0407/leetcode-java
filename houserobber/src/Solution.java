public class Solution {
    public int rob(int[] nums) {
        if (nums.length < 1) return 0;
        else if (nums.length < 2) return nums[0];
        int pprev = nums[0], prev = Math.max(pprev,nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (prev>pprev+nums[i]) {
                pprev = prev;
            } else {
                int tmp = prev;
                prev = pprev + nums[i];
                pprev = tmp;
            }
        }
        return Math.max(prev, pprev);
    }
}