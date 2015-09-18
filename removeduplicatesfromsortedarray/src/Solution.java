public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int length = 1;
        boolean sign = true;
        for (int i = 1; i<nums.length; i++) {
            sign = true;
            for (int j=0; j<length; j++) {
                if (nums[i] == nums[j]) {
                    sign = false;
                    break;
                }
            }
            if (sign) {
                nums[length] = nums[i];
                length ++;
            }
        }
        return length;
    }
}