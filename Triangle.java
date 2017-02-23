public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0 || triangle.get(0).size() == 0)
            return 0;
        List<Integer> last = new ArrayList<>();
        last.add(0);
        int min = 0;
        for(int i = 0; i < triangle.size(); i++) {
            List<Integer> cur = triangle.get(i);
            min = Integer.MAX_VALUE;
            for(int j = 0; j < cur.size(); j++) {
                int sum = Integer.MAX_VALUE;
                if(j - 1 >= 0) sum = Math.min(sum, last.get(j - 1));
                if(j < last.size()) sum = Math.min(sum, last.get(j));
                cur.set(j, cur.get(j) + sum);
                min = Math.min(min, cur.get(j));
            }
            last = cur;
        }
        return min;
    }
}