public class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int ret = 0;
        while(l < r) {
            ret = Math.max(ret, (r - l) * Math.min(height[r], height[l]));
            if(height[l] <= height[r]) l++;
            else r--;
        }
        return ret;
    }
}