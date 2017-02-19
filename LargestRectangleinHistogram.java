public class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int ret = 0;
        for(int i = 0; i <= heights.length; i++) {
            int cur = i == heights.length ? -1 : heights[i];
            while(!stack.empty() && heights[stack.peek()] >= cur) {
                int h = heights[stack.pop()];
                int w = stack.empty() ? i : i - stack.peek() - 1;
                ret = Math.max(ret, h * w);
            }
            stack.push(i);
        }
        return ret;
    }
}