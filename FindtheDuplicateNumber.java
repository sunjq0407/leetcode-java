public class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        while(l + 1 < r) {
            int mid = (r - l) / 2 + l;
            if(nums[mid] >= mid + 1) l = mid;
            else r = mid;
        }
        return nums[l];
    }
}