public class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int n = nums[i];
            while(n > 0 && n <= nums.length && nums[n - 1] != n) {
                int tmp = nums[i];
                nums[i] = nums[n - 1];
                nums[n - 1] = tmp;
                n = nums[i];
            }
        }
        for(int i = 0; i < nums.length; i++)
            if(nums[i] != i + 1) return i + 1;
        return nums.length + 1;
    }
}