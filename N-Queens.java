public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> ret = new ArrayList<>();
        helper(n, new ArrayList<Integer>(), ret);
        return convert(ret, n);
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
    
    private List<List<String>> convert(List<List<Integer>> lists, int n) {
        List<List<String>> ret = new ArrayList<>();
        for(int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            List<String> l = new ArrayList<>();
            for(int j = 0; j < list.size(); j++) {
                int k = list.get(j);
                StringBuilder sb = new StringBuilder();
                for(int p = 0; p < k; p++) sb.append('.');
                sb.append('Q');
                for(int p = k + 1; p < n; p++) sb.append('.');
                l.add(sb.toString());
            }
            ret.add(l);
        }
        return ret;
    }
}