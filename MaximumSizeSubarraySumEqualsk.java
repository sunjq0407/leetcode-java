public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int[] sums = new int[nums.length + 1];
        int ret = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for(int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
            if(map.containsKey(sums[i] - k))
                ret = Math.max(ret, i - map.get(sums[i] - k));
            if(!map.containsKey(sums[i])) map.put(sums[i], i);
        }
        return ret;
    }
}