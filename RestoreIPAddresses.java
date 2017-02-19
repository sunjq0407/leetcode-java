public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        if(s.length() < 4) return ret;
        helper(s, "", ret, 0);
        return ret;
    }
    
    private void helper(String s, String str, List<String> ret, int level) {
        if(level == 4) {
            System.out.println(str);
            if(s.length() == 0) ret.add(str.substring(0, str.length() - 1));
            return;
        }
        
        for(int i = 1; i <= 3 && i <= s.length(); i++)
            if(isValid(s.substring(0, i)))
                helper(s.substring(i), str + s.substring(0, i) + '.', ret, level + 1);
    }
    
    private boolean isValid(String s) {
        if(s.charAt(0) == '0' && s.length() != 1 || Integer.parseInt(s) > 255)
            return false;
        return true;
    }
}