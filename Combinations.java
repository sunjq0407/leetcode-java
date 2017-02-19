public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        helper(1, k, n, new ArrayList<Integer>(), ret);
        return ret;
    }
    
    private void helper(int idx, int k, int n, List<Integer> list,
            List<List<Integer>> ret) {
        if(list.size() == k) {
            ret.add(new ArrayList<>(list));
            return;
        }
        int size = list.size();
        for(int i = idx; i <= n - k + 1 + size; i++) {
            list.add(i);
            helper(i+1, k, n, list, ret);
            list.remove(list.size() - 1);
        }
    }
}