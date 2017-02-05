public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1) return;
        int i = 0;
        for(i = nums.length - 1; i >= 1; i--)
            if(nums[i] > nums[i - 1]) break;
        if(i == 0) {
            Arrays.sort(nums);
            return;
        }
        int j = 0;
        for(j = nums.length - 1; j >= i; j--)
            if(nums[j] > nums[i - 1]) break;
        int tmp = nums[i - 1];
        nums[i - 1] = nums[j];
        nums[j] = tmp;
        Arrays.sort(nums, i, nums.length);
    }
}