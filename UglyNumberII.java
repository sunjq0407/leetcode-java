public class Solution {
    public int nthUglyNumber(int n) {
        int[] f = new int[n];
        f[0] = 1;
        int id2 = 0;
        int id3 = 0;
        int id5 = 0;
        for(int i = 1; i < n; i++) {
            int min = Math.min(2 * f[id2], Math.min(3 * f[id3], 5 * f[id5]));
            f[i] = min;
            if(2 * f[id2] == min) id2++;
            if(3 * f[id3] == min) id3++;
            if(5 * f[id5] == min) id5++;
        }
        return f[n - 1];
    }
}