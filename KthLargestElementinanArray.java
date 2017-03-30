public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    
    private int quickSelect(int[] nums, int left, int right, int k) {
        int pivot = nums[left];
        int l = left;
        int r = right;
        while(l < r) {
            while(l < r && nums[r] >= pivot) r--;
            nums[l] = nums[r];
            while(l < r && nums[l] <= pivot) l++;
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        if(l == nums.length - k) return pivot;
        if(l < nums.length - k) return quickSelect(nums, l + 1, right, k);
        return quickSelect(nums, left, l - 1, k);
    }
}