public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ret = new ArrayList<>();
        if(nums.length == 0) {
            if(lower == upper) ret.add(lower + "");
            else ret.add(lower + "->" + upper);
            return ret;
        }
        for(int i : nums) {
            if(i > lower)
                if(lower == i - 1) ret.add(lower + "");
                else ret.add(lower + "->" + (i - 1));
            lower = i == Integer.MAX_VALUE ? i : i + 1;
        }
        if(nums[nums.length - 1] < upper)
            if(nums[nums.length - 1] + 1 == upper) ret.add(upper + "");
            else ret.add((nums[nums.length - 1] + 1) + "->" + upper);
        return ret;
    }
}