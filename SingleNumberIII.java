public class Solution {
    public int[] singleNumber(int[] nums) {
        int[] ret = new int[2];
        int diff = 0;
        for(int i : nums) diff ^= i;
        diff &= -diff;
        for(int i : nums) {
            if((i & diff) == 0) ret[0] ^= i;
            else ret[1] ^= i;
        }
        return ret;
    }
}