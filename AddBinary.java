public class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        while(i >= 0 || j >= 0) {
            int num = carry;
            if(i >= 0) num += a.charAt(i--) - '0';
            if(j >= 0) num += b.charAt(j--) - '0';
            sb.insert(0, num % 2);
            carry = num / 2;
        }
        if(carry != 0) sb.insert(0, carry);
        return sb.toString();
    }
}