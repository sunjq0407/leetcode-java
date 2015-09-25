public class Solution {
    public int climbStairs(int n) {
        if (n==1) return 1;
        int p2 = 0, p1 = 1, cur = 1;
        for (int i=1; i<n; i++) {
            p2 = p1;
            p1 = cur;
            cur = p1 + p2;
        }
        return cur;
    }
}