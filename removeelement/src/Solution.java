public class Solution {
    public int removeElement(int[] nums, int val) {
        int insert = 0;
        for (int n : nums) {
            if (n != val) {
                nums[insert] = n;
                insert ++;
            }
            else continue;
        }
        return insert;
    }
}