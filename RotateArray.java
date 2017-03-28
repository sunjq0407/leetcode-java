public class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if(k == 0) return;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    
    private void reverse(int[] nums, int l, int r) {
        for(int i = l; i <= (r - l) / 2 + l; i++) {
            int tmp = nums[i];
            nums[i] = nums[r - i + l];
            nums[r - i + l] = tmp;
        }
    }
}