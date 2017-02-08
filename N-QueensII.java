public class Solution {
    public int totalNQueens(int n) {
        List<List<Integer>> ret = new ArrayList<>();
        helper(n, new ArrayList<>(), ret);
        return ret.size();
    }
    
    private void helper(int n, List<Integer> l, List<List<Integer>> ret) {
        if(l.size() == n) {
            ret.add(new ArrayList<>(l));
            return;
        }
        int i = l.size();
        for(int j = 0; j < n; j++) {
            int x = 0;
            for(; x < l.size(); x++) {
                int y = l.get(x);
                if(y == j || Math.abs(x - i) == Math.abs(y - j)) break;
            }
            if(x == l.size()) {
                l.add(j);
                helper(n, l, ret);
                l.remove(l.size() - 1);
            }
        }
    }
}