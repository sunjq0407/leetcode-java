public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        helper(nums, 0, new ArrayList<Integer>(), ret);
        return ret;
    }
    
    private void helper(int[] nums, int idx, List<Integer> list,
            List<List<Integer>> ret) {
        ret.add(new ArrayList<>(list));
        for(int i = idx; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1] && i != idx)
                continue;
            list.add(nums[i]);
            helper(nums, i + 1, list, ret);
            list.remove(list.size() - 1);
        }
    }
}