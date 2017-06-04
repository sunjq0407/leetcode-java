public class Solution {
    public void wiggleSort(int[] nums) {
        int mid = partition(nums, 0, nums.length-1, nums.length/2);
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) ans[i] = mid;
        if (nums.length % 2 == 0) {
            int l = nums.length - 2;
            int r = 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < mid) {
                    ans[l] = nums[i];
                    l -= 2;
                } else if (nums[i] > mid) {
                    ans[r] = nums[i];
                    r += 2;
                }
            }
        } else {
            int l = 0;
            int r = nums.length - 2;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < mid) {
                    ans[l] = nums[i];
                    l += 2;
                } else if (nums[i] > mid) {
                    ans[r] = nums[i];
                    r -= 2;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) nums[i] = ans[i];
    }
    
    public int partition(int[] nums, int l, int r, int rank) {
        int left = l, right = r;
        int now = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= now) right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= now) left++;
            nums[right] = nums[left];
        }
        nums[left] = now;
        if (left - l == rank) return now;
        else if (left - l < rank)
            return partition(nums, left + 1, r, rank - (left - l + 1));
        else return partition(nums, l, right - 1, rank);
    }
}