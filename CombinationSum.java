public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        helper(candidates, 0, target, 0, new ArrayList<Integer>(), ret);
        return ret;
    }
    
    private void helper(int[] candidates, int id, int target, int sum,
            List<Integer> list, List<List<Integer>> ret) {
        if(sum == target) {
            ret.add(new ArrayList<>(list));
            return;
        }
        if(sum > target || id >= candidates.length) return;
        while(sum <= target) {
            helper(candidates, id + 1, target, sum, new ArrayList<>(list), ret);
            list.add(candidates[id]);
            sum += candidates[id];
        }
    }
}