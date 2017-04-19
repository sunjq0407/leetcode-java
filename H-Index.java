public class Solution {
    public int hIndex(int[] citations) {
        int[] f = new int[citations.length + 1];
        for(int i : citations) {
            if(i > citations.length) f[f.length - 1] ++;
            else f[i]++;
        }
        int sum = 0;
        for(int i = f.length - 1; i >= 0; i--) {
            sum += f[i];
            if(i <= sum) return i;
        }
        return 0;
    }
}