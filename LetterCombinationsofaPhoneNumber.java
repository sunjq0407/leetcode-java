public class Solution {
    char[][] map = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},
                {'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() != 0) helper(digits, 0, "", result);
        return result;
    }
    private void helper(String digits, int index, String str, List<String> result) {
        if(index == digits.length()) {
            result.add(str);
            return;
        }
        int num = Integer.parseInt(digits.substring(index++, index));
        for(char c: map[num]) helper(digits, index, str + c, result);
    }
}