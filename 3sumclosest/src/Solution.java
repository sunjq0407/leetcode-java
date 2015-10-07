import java.util.*;
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int left = 0, right = 0, sum = 0;
        Arrays.sort(nums);
        int ret = nums[0]+nums[1]+nums[2];
        int diff = Math.abs(ret-target);
        for (int i=0; i<nums.length-2; i++) {
            left = i+1;
            right = nums.length-1;
            while (left<right) {
                sum = nums[i]+nums[left]+nums[right];
                if (sum==target) return sum;
                if (Math.abs(sum-target)<diff) {
                    ret = sum;
                    diff = Math.abs(sum-target);
                }
                if (sum<target) left ++;
                if (sum>target) right --;
            }
        }
        return ret;
    }
}