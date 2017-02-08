public class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int h = 0;
        int ret = 0;
        while(l < r) {
            ret += Math.max(0, h - height[l]);
            ret += Math.max(0, h - height[r]);
            h = Math.max(h, Math.min(height[l], height[r]));
            if(height[l] <= height[r]) l++;
            else r--;
        }
        return ret;
    }
}