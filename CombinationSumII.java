public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<Integer>());
        return result;
    }
    
    private void helper(int[] candidates, int target, int index, List<Integer> sol) {
        if(target == 0) result.add(new ArrayList(sol));
        else if(target <= 0 || index >= candidates.length) return;
        else {
            int prev = 0;
            for (int i = index; i < candidates.length; i++) {
                if(candidates[i] != prev) {
                    sol.add(candidates[i]);
                    helper(candidates, target - candidates[i], i + 1, sol);
                    prev = candidates[i];
                    sol.remove(sol.size() - 1);
                }
            }
        }
    }
}