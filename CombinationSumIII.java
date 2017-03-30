public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        helper(k, n, new ArrayList<>(), 0, ret);
        return ret;
    }
    
    private void helper(int k, int n, List<Integer> list, int sum,
            List<List<Integer>> ret) {
        if(list.size() == k) {
            if(sum == n) ret.add(new ArrayList<>(list));
            return;
        }
        if(sum >= n) return;
        for(int i = list.size() == 0 ? 1 : list.get(list.size() - 1) + 1; i <= 9; i++) {
            list.add(i);
            helper(k, n, list, sum + i, ret);
            list.remove(list.size() - 1);
        }
    }
}