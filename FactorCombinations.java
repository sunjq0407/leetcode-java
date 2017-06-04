public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ret = new ArrayList<>();
        helper(n, 2, new ArrayList<>(), ret);
        return ret;
    }
    
    private void helper(int n, int min, List<Integer> list, List<List<Integer>> ret) {
        for(int i = min; i * i <= n; i++) {
            if(n % i == 0) {
                list.add(i);
                list.add(n / i);
                ret.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                helper(n / i, i, list, ret);
                list.remove(list.size() - 1);
            }
        }
    }
}