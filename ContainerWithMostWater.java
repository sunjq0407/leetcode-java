public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length-1;
        while(left < right) {
            int area;
            int tmp;
            if(height[left] <= height[right]) {
                tmp = height[left];
                area = (right - left) * tmp;
                while(height[++left] < tmp);
            } else {
                tmp = height[right];
                area = (right - left) * tmp;
                while (height[--right] < tmp);
            }
            if(area > max) max = area;
        }
        return max;
    }
}