public class Solution {
    public String convertToTitle(int n) {
        StringBuffer rev = new StringBuffer();
        String ret = "";
        int i = 0;
        while (n!=0) {
            n--;
            i = n%26;
            rev.append((char)('A'+i));
            n /= 26;
        }
        rev = rev.reverse();
        ret = rev.toString();
        return ret;
    }
}