public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sums = new long[nums.length + 1];
        int ret = 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        for(int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
            for(long j = sums[i] - upper; j <= sums[i] - lower; j++)
                if(map.containsKey(j)) ret += map.get(j);
            map.put(sums[i], map.getOrDefault(sums[i], 0) + 1);
        }
        return ret;
    }
}