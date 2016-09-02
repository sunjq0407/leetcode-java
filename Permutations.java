public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void helper(int[] nums, int index, List<Integer> cur, List<List<Integer>> result) {
        if(index == nums.length) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = 0; i <= cur.size(); i++) {
            cur.add(i, nums[index]);
            helper(nums, index + 1, cur, result);
            cur.remove(i);
        }
    }
}