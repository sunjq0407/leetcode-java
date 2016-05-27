public class Solution {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                int j = nums.length - 1;
                for (; j >= i; j--) if (nums[j] > nums[i]) break;
                swap(nums, i, j);
                i++; j = nums.length - 1;
                while(i < j) swap(nums, i++, j--);
                return;
            }
        }
        int i = 0; int j = nums.length - 1;
        while(i < j) swap(nums, i++, j--);
    }
    
    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
