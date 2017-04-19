public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ret = new ArrayList<>();
        if(num.length() == 0) return ret;
        helper(num, target, 0, "", 0, 0, ret);
        return ret;
    }
    
    private void helper(String num, int target, int idx, String str, long val, long multi, List<String> list) {
        if(idx == num.length()) {
            if(val == target) list.add(str);
            return;
        }
        for(int i = idx; i < num.length(); i++) {
            if(i > idx && num.charAt(idx) == '0') break;
            long n = Long.parseLong(num.substring(idx, i + 1));
            if(idx == 0) helper(num, target, i + 1, str + n, n, n, list);
            else {
                helper(num, target, i + 1, str + "+" + n, val + n, n, list);
                helper(num, target, i + 1, str + "-" + n, val - n, -n, list);
                helper(num, target, i + 1, str + "*" + n, val - multi + multi * n, multi * n, list);
            }
        }
    }
}