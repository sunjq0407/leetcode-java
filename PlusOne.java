public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            int num = digits[i] + carry;
            carry = num / 10;
            digits[i] = num % 10;
            if(carry == 0) break;
        }
        if(carry == 0) return digits;
        int[] ret = new int[digits.length + 1];
        ret[0] = 1;
        for(int i = 1; i < ret.length; i++) ret[i] = 0;
        return ret;
    }
}