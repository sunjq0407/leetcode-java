public class Solution {
    public int jump(int[] nums) {
        if(nums.length <= 1) return 0;
        int i = 0;
        int step = 0;
        while(i < nums.length) {
            int max = 0;
            int next = i + 1;
            step ++;
            for(int j = i + 1; j <= i + nums[i]; j++) {
                if(j >= nums.length - 1) return step;
                if(j + nums[j] > max) {
                    max = j + nums[j];
                    next = j;
                }
            }
            i = next;
        }
        return step;
    }
}