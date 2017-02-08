public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<Integer>(), ret);
        return ret;
    }
    
    private void helper(int[] candidates, int target, int id,
            List<Integer> list, List<List<Integer>> ret) {
        if(target == 0) {
            ret.add(new ArrayList<>(list));
            return;
        }
        if(id >= candidates.length || target < 0) return;
        int next = id + 1;
        while(next < candidates.length && candidates[next] == candidates[next - 1])
            next++;
        list.add(candidates[id]);
        helper(candidates, target - candidates[id], id + 1, list, ret);
        list.remove(list.size() - 1);
        helper(candidates, target, next, list, ret);
    }
}