public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<>();
        ret.add(1);
        for(int i = 0; i < rowIndex; i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for(int j = 0; j < i; j++)
                cur.add(ret.get(j) + ret.get(j + 1));
            cur.add(1);
            ret = cur;
        }
        return ret;
    }
}