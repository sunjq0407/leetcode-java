public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[]{-1, -1};
        if(nums.length == 0) return ret;
        int l = 0;
        int r = nums.length - 1;
        while(l + 1 < r) {
            int mid = (r - l) / 2 + l;
            if(nums[mid] < target) l = mid;
            else r = mid;
        }
        if(nums[l] == target) ret[0] = l;
        else if(nums[r] == target) ret[0] = r;
        l = 0;
        r = nums.length - 1;
        while(l + 1 < r) {
            int mid = (r - l) / 2 + l;
            if(nums[mid] <= target) l = mid;
            else r = mid;
        }
        if(nums[r] == target) ret[1] = r;
        else if(nums[l] == target) ret[1] = l;
        return ret;
    }
}