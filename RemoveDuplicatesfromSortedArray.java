public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        while(j < nums.length) {
            while(j + 1 < nums.length && nums[j] == nums[j + 1]) j++;
            nums[i++] = nums[j++];
        }
        return i;
    }
}