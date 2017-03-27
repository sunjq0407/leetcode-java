public class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l + 1 < r) {
            int mid = (r - l) / 2 + l;
            if(nums[mid - 1] > nums[mid]) r = mid;
            else if(nums[mid + 1] > nums[mid]) l = mid;
            else return mid;
        }
        return nums[l] >= nums[r] ? l : r;
    }
}