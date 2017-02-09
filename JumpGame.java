public class Solution {
    public boolean canJump(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if(nums[i] == 0) return i == nums.length - 1;
            int max = i + 1;
            int next = i + 1;
            for(int j = i + 1; j <= i + nums[i]; j++) {
                if(j >= nums.length - 1) return true;
                if(j + nums[j] > max) {
                    max = j + nums[j];
                    next = j;
                }
            }
            i = next;
        }
        return i >= nums.length - 1;
    }
}