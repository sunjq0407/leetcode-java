public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;
        if(nums[0] >= s) return 1;
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
            sums[i] = sums[i - 1] + nums[i];
        int ret = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length; i++) {
            int target = sums[i] - s;
            if(target < 0) continue;
            int l = 0;
            int r = i - 1;
            while(l + 1 < r) {
                int mid = (r - l) / 2 + l;
                if(sums[mid] > target) r = mid - 1;
                else l = mid;
            }
            int id = sums[r] <= target ? r : l;
            if(sums[l] > target) id = -1;
            ret = Math.min(ret, i - id);
        }
        return ret == Integer.MAX_VALUE ? 0 : ret;
    }
}