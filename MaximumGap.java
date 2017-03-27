public class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length < 2) return 0;
        int minNum = nums[0];
        int maxNum = nums[0];
        for(int i : nums) {
            minNum = Math.min(minNum, i);
            maxNum = Math.max(maxNum, i);
        }
        if(minNum == maxNum) return 0;
        double ave = (maxNum - minNum) * 1.0 / (nums.length - 1);
        if(ave == 0) ave++;
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            min[i] = -1;
            max[i] = -1;
        }
        for(int i = 0; i < nums.length; i++) {
            int tmp = (int)((nums[i] - minNum) / ave);
            min[tmp] = min[tmp] == -1 ? nums[i] : Math.min(min[tmp], nums[i]);
            max[tmp] = max[tmp] == -1 ? nums[i] : Math.max(max[tmp], nums[i]);
        }
        int ret = (int)ave;
        int l = 0;
        int r = 1;
        while(l < nums.length - 1) {
            while(r < nums.length && min[r] == -1) r++;
            if(r >= nums.length) break;
            ret = Math.max(ret, min[r] - max[l]);
            l = r++;
        }
        return ret;
    }
}