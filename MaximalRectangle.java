public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int ret = 0;
        int[][] height = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(i == 0) height[i][j] = matrix[i][j] == '1' ? 1 : 0;
                else height[i][j] = matrix[i][j] == '1' ? height[i-1][j] + 1 : 0;
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            Stack<Integer> stack = new Stack<>();
            for(int j = 0; j <= matrix[0].length; j++) {
                int cur = j == matrix[0].length ? -1 : height[i][j];
                while(!stack.empty() && height[i][stack.peek()] > cur) {
                    int h = height[i][stack.pop()];
                    int w = stack.empty() ? j : j - stack.peek() - 1;
                    ret = Math.max(ret, h * w);
                }
                stack.push(j);
            }
        }
        return ret;
    }
}