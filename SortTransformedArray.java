public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if(nums.length == 0) {
            return nums;
        }
        int[] ret = new int[nums.length];
        int id = 0;
        double pivot = (double)(-b) / (2 * a);
        if((a == 0 && b >= 0) || (nums[0] >= pivot && a > 0)
                || (nums[nums.length - 1] <= pivot && a < 0)) {
            for(int i = 0; i < nums.length; i++) {
                ret[id++] = a * nums[i] * nums[i] + b * nums[i] + c;
            }
            return ret;
        }
        if((a == 0 && b < 0) || (nums[0] >= pivot && a < 0)
                || (nums[nums.length - 1] <= pivot && a > 0)) {
            for(int i = nums.length - 1; i >= 0; i--) {
                ret[id++] = a * nums[i] * nums[i] + b * nums[i] + c;
            }
            return ret;
        }
        int i = 0;
        for(; i < nums.length; i++) {
            if(nums[i] > pivot) {
                break;
            }
        }
        if(a > 0) {
            int j = i - 1;
            while(j >= 0 || i < nums.length) {
                if(i >= nums.length || (j >= 0 && pivot - nums[j] < nums[i] - pivot)) {
                    ret[id++] = a * nums[j] * nums[j] + b * nums[j--] + c;
                } else {
                    ret[id++] = a * nums[i] * nums[i] + b * nums[i++] + c;
                }
            }
        } else {
            int j = 0;
            int k = nums.length - 1;
            while(j < i || k >= i) {
                if(k < i || pivot - nums[j] > nums[k] - pivot) {
                    ret[id++] = a * nums[j] * nums[j] + b * nums[j++] + c;
                } else {
                    ret[id++] = a * nums[k] * nums[k] + b * nums[k--] + c;
                }
            }
        }
        return ret;
    }
}