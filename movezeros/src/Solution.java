public class Solution {
    public void moveZeroes(int[] nums) {
        int offset = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i]==0) {
                offset++;
                continue;
            }
            nums[i-offset] = nums[i];
        }
        for (int i=0; i<offset; i++) {
            nums[nums.length-i-1] = 0;
        }
    }
}