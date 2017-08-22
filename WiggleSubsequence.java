class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 2) {
            return nums.length;
        }
        int i = 0;
        while(i < nums.length - 1 && nums[i] == nums[i + 1]) {
            i++;
        }
        if(i == nums.length - 1) {
            return 1;
        }
        int ret = 2;
        boolean ascending = nums[i] < nums[i + 1];
        int pivot = -1;
        for(int j = i + 1; j < nums.length - 1; j++) {
            if(ascending && nums[j + 1] < nums[j]) {
                pivot = nums[j + 1];
                ret ++;
                ascending = !ascending;
            } else if(!ascending && nums[j + 1] > nums[j]) {
                pivot = nums[j + 1];
                ret ++;
                ascending = !ascending;
            }
        }
        return ret;
    }
}