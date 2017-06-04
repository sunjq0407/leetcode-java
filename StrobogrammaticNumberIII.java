public class Solution {
    public int strobogrammaticInRange(String low, String high) {
        List<String> list = new ArrayList<>();
        for(int i = low.length(); i <= high.length(); i++)
            helper(i, "", "", list);
        int cnt = 0;
        for(String str : list)
            if(compare(str, low) >= 0 && compare(str, high) <= 0) cnt++;
        return cnt;
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
    
    private int compare(String a, String b) {
        if(a.length() != b.length()) return a.length() - b.length();
        for(int i = 0; i < a.length(); i++)
            if(a.charAt(i) != b.charAt(i)) return a.charAt(i) - b.charAt(i);
        return 0;
    }
}