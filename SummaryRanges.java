public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<>();
        if(nums.length == 0) return ret;
        int start = nums[0];
        int cur = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == cur + 1) cur ++;
            else {
                if(start == cur) ret.add("" + cur);
                else ret.add(start + "->" + cur);
                start = nums[i];
                cur = nums[i];
            }
        }
        if(start == cur) ret.add("" + cur);
        else ret.add(start + "->" + cur);
        return ret;
    }
}