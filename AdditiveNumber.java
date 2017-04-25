public class Solution {
    public boolean isAdditiveNumber(String num) {
        if(num.length() == 0) return false;
        for(int i = 1; i <= num.length() / 2; i++) {
            long n1 = Long.parseLong(num.substring(0, i));
            for(int j = i + 1; j <= num.length() / 3 * 2; j++) {
                long n2 = Long.parseLong(num.substring(i, j));
                if(helper(num, j, n1, n2)) return true;
                if(num.charAt(i) == '0') break;
            }
            if(num.charAt(0) == '0') break;
        }
        return false;
    }
    
    private boolean helper(String num, int id, long n1, long n2) {
        if(id == num.length()) return true;
        long sum = n1 + n2;
        int len = 0;
        while(sum > 0) {
            len ++;
            sum /= 10;
        }
        if(len == 0) len ++;
        if(id + len > num.length() || (num.charAt(id) == '0' && n1 + n2 != 0)) return false;
        sum = Long.parseLong(num.substring(id, id + len));
        if(sum != n1 + n2) return false;
        return helper(num, id + len, n2, sum);
    }
}