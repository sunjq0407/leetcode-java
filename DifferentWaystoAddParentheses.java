public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(Character.isDigit(c)) continue;
            List<Integer> a = diffWaysToCompute(input.substring(0, i));
            List<Integer> b = diffWaysToCompute(input.substring(i + 1));
            for(int j : a) {
                for(int k : b) {
                    if(c == '+') ret.add(j + k);
                    else if(c == '-') ret.add(j - k);
                    else ret.add(j * k);
                }
            }
        }
        if(ret.size() == 0) ret.add(Integer.valueOf(input));
        return ret;
    }
}