public class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l + 1 < r) {
            int mid = (r - l) / 2 + l;
            if(nums[mid] > nums[r]) l = mid;
            else if(nums[mid] < nums[r]) r = mid;
            else r--;
        }
        return Math.min(nums[l], nums[r]);
    }
}