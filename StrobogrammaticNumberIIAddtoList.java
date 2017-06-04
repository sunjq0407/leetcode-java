public class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> ret = new ArrayList<>();
        helper(n, "", "", ret);
        return ret;
    }
    
    private void helper(int n, String prefix, String suffix, List<String> ret) {
        if(n <= 1) {
            if(n == 0) ret.add(prefix + suffix);
            else {
                ret.add(prefix + '1' + suffix);
                ret.add(prefix + '8' + suffix);
                ret.add(prefix + '0' + suffix);
            }
            return;
        }
        helper(n - 2, prefix + '1', '1' + suffix, ret);
        helper(n - 2, prefix + '6', '9' + suffix, ret);
        helper(n - 2, prefix + '8', '8' + suffix, ret);
        helper(n - 2, prefix + '9', '6' + suffix, ret);
        if(prefix.length() != 0)
            helper(n - 2, prefix + '0', '0' + suffix, ret);
    }
}