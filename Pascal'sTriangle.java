public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if(numRows == 0) return ret;
        ret.add(new ArrayList<>(Arrays.asList(1)));
        for(int i = 1; i < numRows; i++) {
            List<Integer> last = ret.get(i - 1);
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for(int j = 0; j < i - 1; j++) 
                cur.add(last.get(j) + last.get(j + 1));
            cur.add(1);
            ret.add(cur);
        }
        return ret;
    }
}