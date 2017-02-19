public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if(nums.length == 0) return ret;
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<Integer>(), ret);
        return ret;
    }
    
    private void helper(int[] nums, int idx, List<Integer> list,
            List<List<Integer>> ret) {
        ret.add(new ArrayList<>(list));
        if(idx == nums.length) return;
        for(int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            helper(nums, i + 1, list, ret);
            list.remove(list.size() - 1);
        }
    }
}