public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] f = new int[nums.length];
        Arrays.fill(f, Integer.MAX_VALUE);
        for(int n : nums) {
            int l = 0;
            int r = f.length - 1;
            while(l < r) {
                int mid = (r - l) / 2 + l;
                if(f[mid] < n) l = mid + 1;
                else r = mid;
            }
            f[l] = n;
        }
        for(int i = f.length - 1; i >= 0; i--)
            if(f[i] != Integer.MAX_VALUE) return i + 1;
        return 0;
    }
}