public class Solution {
    public String convertToTitle(int n) {
        String ret = "";
        while(n != 0) {
            int offset = n % 26 == 0 ? 26 : n % 26;
            ret = (char)('A' + offset - 1) + ret;
            n = (n - offset) / 26;
        }
        return ret;
    }
}