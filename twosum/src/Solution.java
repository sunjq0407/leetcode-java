import java.util.*;
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        Map val = new HashMap<Integer, Integer>();
        for (int i=0; i<nums.length; i++)
            val.put(nums[i], i);
        for (int i=0; i<nums.length; i++) {
            ret[0] = i+1;
            if (val.containsKey(target-nums[i])) {
                ret[1] = (int)val.get(target-nums[i])+1;
                if (ret[0]!=ret[1]) return ret;
            }
        }
        return ret;
    }
}