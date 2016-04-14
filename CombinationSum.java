public class Solution {
    private List<List<Integer>> results = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> sol = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, sol);
        return results;
    }
    private void helper(int[] candidates, int target, int offset,List<Integer> sol) {
        if(target == 0) {
            results.add(new ArrayList<Integer>(sol));
            return;
        }
        for(int i=offset; i<candidates.length; i++) {
            int elem = candidates[i];
            if(i<candidates.length-1 && elem==candidates[i+1]) continue;
            if(elem > target) break;
            sol.add(elem);
            helper(candidates, target-elem, i, sol);
            sol.remove(sol.size() -1);
        }
    }
}