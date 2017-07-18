public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int l = Integer.MAX_VALUE;
        int r = Integer.MAX_VALUE;
        for(int i : nums) {
            if(i <= l) l = i;
            else if(i <= r) r = i;
            else return true;
        }
        return false;
    }
}