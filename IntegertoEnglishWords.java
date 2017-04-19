public class Solution {
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        String[] ones = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] teens = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] thousands = new String[]{"", "Thousand", "Million", "Billion"};
        String ret = "";
        int tid = 0;
        while(num > 0) {
            int n = num % 1000;
            num /= 1000;
            if(n == 0) {
                tid++;
                continue;
            }
            String str = "";
            int hundred = n / 100;
            n %= 100;
            if(n < 10) str = ones[n];
            else if(n >= 10 && n <= 19) str = teens[n - 10];
            else str = tens[n / 10] + " " + ones[n % 10];
            if(hundred != 0) str = ones[hundred] +" Hundred " + str;
            ret = str.trim() + " " + thousands[tid++] + " " + ret;
        }
        return ret.trim();
    }
}