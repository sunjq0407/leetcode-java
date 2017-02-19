public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;
        int l = 0;
        int r = nums.length - 1;
        while(l + 1 < r) {
            int mid = (r - l) / 2 + l;
            if(nums[l] < nums[mid]) {
                if(nums[l] <= target && target <= nums[mid]) r = mid;
                else l = mid;
            } else if(nums[l] > nums[mid]){
                if(nums[mid] <= target && target <= nums[r]) l = mid;
                else r = mid;
            } else l++;
        }
        if(nums[l] == target || nums[r] == target) return true;
        return false;
    }
}