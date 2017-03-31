public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        int a = 0;
        int b = 0;
        int cntA = 0;
        int cntB = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == a) cntA++;
            else if(nums[i] == b) cntB++;
            else if(cntA == 0) {
                a = nums[i];
                cntA = 1;
            } else if(cntB == 0) {
                b = nums[i];
                cntB = 1;
            } else {
                cntA--;
                cntB--;
            }
        }
        cntA = 0;
        cntB = 0;
        for(int i : nums) {
            if(i == a) cntA++;
            else if(i == b) cntB++;
        }
        if(cntA > nums.length / 3) ret.add(a);
        if(cntB > nums.length / 3) ret.add(b);
        return ret;
    }
}