import java.util.*;
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set buffer = new HashSet<Integer>();
        for (int i=0; i<nums.length; i++) {
            if (buffer.contains(nums[i])) return true;
            else buffer.add(nums[i]);
        }
        return false;
    }
}