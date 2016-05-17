public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int i = 0, j = 0;
        while(++i < nums.length) {
            if(nums[i] == nums[j]) continue;
            nums[++j] = nums[i];
        }
        return ++j;
    }
}