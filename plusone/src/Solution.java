import java.util.*;
public class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        digits[length-1] ++;
        int[] ret = new int[length+1];
        for (int i=length-1; i>=0; i--) {
            ret[i+1] += digits[i];
            ret[i] =+ ret[i+1]/10;
            ret[i+1] %= 10;
        }
        if (ret[0] == 0) return Arrays.copyOfRange(ret, 1 , ret.length);
        else return ret;
    }
}