import java.util.*;
public class Solution {
    public boolean isHappy(int n) {
        Set result = new HashSet<Integer>();
        int a = n;
        while (true) {
            a = cal(a);
            if (a == 1) return true;
            else if (result.contains(a)) return false;
            else result.add(a);
        }
    }
    private int cal(int n) {
        int ret = 0;
        while (n!=0) {
            ret += (n%10)*(n%10);
            n /= 10;
        }
        return ret;
    }
}