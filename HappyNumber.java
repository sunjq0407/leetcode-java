public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(true) {
            int m = 0;
            while(n != 0) {
                m += (n % 10) * (n % 10);
                n /= 10;
            }
            if(m == 1) return true;
            if(set.contains(m)) return false;
            set.add(m);
            n = m;
        }
    }
}