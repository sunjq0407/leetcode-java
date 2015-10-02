import java.util.*;
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map buffer = new HashMap<Integer, Integer>();
        for (int i=0; i<nums.length; i++) {
            if (buffer.containsKey(nums[i])) {
                if (Math.abs(i-(int)buffer.get(nums[i]))<=k) return true;
            }
            buffer.put(nums[i], i);
        }
        return false;
    }
}