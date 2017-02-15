public class Solution {
    public int mySqrt(int x) {
        if(x <= 1) return x;
        long left = 1;
        long right = x / 2;
        while(left + 1 < right) {
            long mid = (right - left) / 2 + left;
            if(x > mid * mid) left = mid;
            else if(x < mid * mid) right = mid;
            else return (int)mid;
        }
        if(right * right <= x) return (int)right;
        return (int)left;
    }
}