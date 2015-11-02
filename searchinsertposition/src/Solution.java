public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 1) return nums[0]>=target ? 0 : 1;
        if (nums[0]>=target) return 0;
        if (nums[nums.length-1]<target) return nums.length;
        else return helper(nums, target, 0, nums.length-1);
    }
    private int helper(int[] nums, int target, int begin, int end) {
        int mid = (begin+end)/2;
        if (begin == end - 1) return end;
        if (begin == end) return 0;
        else if (nums[mid] < target) return helper(nums, target, mid, end);
        else if (nums[mid] >= target) return helper(nums, target, begin, mid);
        return 0;
    }
}