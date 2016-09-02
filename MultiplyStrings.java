public class Solution {
    public String multiply(String num1, String num2) {
        int i = 0, j = 0, carry = 0;
        int[] result = new int[num1.length() + num2.length()];
        for(i = num1.length() - 1; i >= 0; i--) {
            carry = 0;
            for(j = num2.length() - 1; j >= 0; j--) {
                int tmp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + carry + result[i + j + 1];
                result[i + j + 1] = tmp % 10;
                carry = tmp / 10;
            }
            result[i + j + 1] = carry;
        }
        if(carry != 0) result[i + j + 2] = carry;
        StringBuilder sb = new StringBuilder();
        i = 0;
        while(i < result.length - 1 && result[i] == 0) i++;
        while(i < result.length) sb.append(result[i++]);
        return sb.toString();
    }
}