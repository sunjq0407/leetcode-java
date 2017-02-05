public class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int l = 0;
        int r = nums.length - 1;
        while(l + 1 < r) {
            int mid = (r - l) / 2 + l;
            if(nums[l] < nums[mid]) {
                if(nums[l] <= target && target <= nums[mid]) r = mid;
                else l = mid;
            } else {
                if(nums[mid] <= target && target <= nums[r]) l = mid;
                else r = mid;
            }
        }
        if(nums[l] == target) return l;
        if(nums[r] == target) return r;
        return -1;
    }
}