import java.util.*;
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List result = new ArrayList<List<Integer>>();
        if (nums.length<4) return result;
        Arrays.sort(nums);
        for (int j=0; j<nums.length; j++) {
            for (int i=j+1; i<nums.length; i++) {
                int low = i+1;
                int high = nums.length -1;
                while (low<high) {
                    if(nums[j]+nums[i]+nums[low]+nums[high]==target){
                        result.add(Arrays.asList(nums[j], nums[i], nums[low], nums[high]));
                        while (j+1<nums.length && nums[j+1]==nums[j]) j++;
                        while (i+1<nums.length && nums[i+1]==nums[i]) i++;
                        while (low+1<nums.length && nums[low]==nums[low+1]) low++;
                        while (high-1>=0 && nums[high]==nums[high-1]) high--;
                        low++;
                        high--;
                    } else if (nums[j]+nums[i]+nums[low]+nums[high]>target) high--;
                    else low++;
                }
            }
        }
        return result;
    }
}