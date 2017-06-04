public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums.length == 0) return 0;
        int cnt = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r) {
                if(nums[i] + nums[l] + nums[r] >= target) r--;
                else {
                    cnt += r - l;
                    l++;
                } 
            }
        }
        return cnt;
    }
}