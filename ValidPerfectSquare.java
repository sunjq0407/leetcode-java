public class Solution {
    public boolean isPerfectSquare(int num) {
        long l = 1;
        long r = num;
        while(l + 1 < r) {
            long mid = (r - l) / 2 + l;
            if(mid * mid > num) {
                r = mid;
            } else if(mid * mid <= num) {
                l = mid;
            }
        }
        return l * l == num || r * r == num;
    }
}