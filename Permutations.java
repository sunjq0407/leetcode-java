public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        helper(nums, new ArrayList<Integer>(), ret, new HashSet<Integer>());
        return ret;
    }
    
    private void helper(int[] nums, List<Integer> l,
            List<List<Integer>> ret, HashSet<Integer> set) {
        if(l.size() == nums.length) {
            ret.add(new ArrayList<>(l));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i])) {
                set.add(nums[i]);
                l.add(nums[i]);
                helper(nums, l, ret, set);
                set.remove(nums[i]);
                l.remove(l.size() - 1);
            }
        }
    }
}