public class Solution {
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while(i - j * j >= 0)
                min = Math.min(min, f[i - j * j++] + 1);
            f[i] = min;
        }
        return f[n];
    }
}