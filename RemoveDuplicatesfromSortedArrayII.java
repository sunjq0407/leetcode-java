public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i == nums.length - 1 || nums[i] != nums[i+1]) {
                nums[len++] = nums[i];
                continue;
            }
            while(i+2 < nums.length && nums[i] == nums[i+2]) i++;
            nums[len++] = nums[i];
            nums[len++] = nums[i++];
        }
        return len;
    }
}