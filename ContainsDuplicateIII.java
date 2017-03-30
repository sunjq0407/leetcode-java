public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(i > k) set.remove((long)nums[i - k - 1]);
            long tmp = (long)nums[i];
            if(set.ceiling(tmp) != null
                    && set.ceiling(tmp) - nums[i] <= t) return true;
            if(set.floor(tmp) != null
                    && nums[i] - set.floor(tmp) <= t) return true;
            set.add(tmp);
        }
        return false;
    }
}