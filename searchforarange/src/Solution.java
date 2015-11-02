public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = {-1, -1};
        int mid = helper(nums, target, 0, nums.length-1, 1);
        if (mid == -1) return ret;
        ret[0] = helper(nums, target, 0, mid, 2);
        ret[1] = helper(nums, target, mid, nums.length-1, 3);
        return ret;
    }
    private int helper(int[] nums, int target, int begin, int end, int mode) {
        int mid = (begin+end)/2;
        if (begin == end) {
            if (mode == 1 && nums[mid] != target) return -1;
            if (mode == 2 && (begin == 0 || nums[mid-1] != target)) return mid;
            if (mode == 3 && (end == nums.length-1 || nums[mid+1] != target)) return mid;
        }
        if (nums[mid] == target) {
            if (mode == 1) return mid;
            if (mode == 2) return helper(nums, target, begin, mid, mode);
            if (mode == 3) {
                if (begin == end - 1) {
                    if (nums[end] == target) return end;
                    else return begin;
                }
                return helper(nums, target, mid, end, mode);
            }
        }
        else if (nums[mid] > target) return helper(nums, target, begin, mid, mode);
        else if (nums[mid] < target) return helper(nums, target, mid+1, end, mode);
        return 0;
    }
}