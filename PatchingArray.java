public class Solution {
    public int minPatches(int[] nums, int n) {
        int ret = 0;
        int id = 0;
        long i = 1;
        while(i <= n) {
            if(id < nums.length && nums[id] <= i) i += nums[id++];
            else {
                i *= 2;
                ret ++;
            }
        }
        return ret;
    }
}