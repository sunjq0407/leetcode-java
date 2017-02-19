public class Solution {
    public List<Integer> grayCode(int n) {
        if(n == 0) return new ArrayList<>(Arrays.asList(0));
        if(n == 1) return new ArrayList<>(Arrays.asList(0, 1));
        List<Integer> ret = grayCode(n - 1);
        for(int i = ret.size() - 1; i >= 0; i--) 
            ret.add((1 << n - 1) + ret.get(i));
        return ret;
    }
}