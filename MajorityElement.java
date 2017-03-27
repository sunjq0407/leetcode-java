public class Solution {
    public int majorityElement(int[] nums) {
        int ret = nums[0];
        int cnt = 1;
        for(int i = 1; i < nums.length; i++) {
            if(cnt == 0) {
                ret = nums[i];
                cnt ++;
            } else if(ret == nums[i]) cnt++;
            else cnt--;
        }
        return ret;
    }
}