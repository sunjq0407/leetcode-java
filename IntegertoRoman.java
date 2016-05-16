public class Solution {
	public String intToRoman(int num) {
		if(num <= 0) return "";
	    int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	    String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	    StringBuilder sb = new StringBuilder();
	    int i = 0;
	    while (num > 0) {
	        int j = num / nums[i];
	        num %= nums[i];
	        while(j-- >0) sb.append(romans[i]);
	        i++;
	    }
	    return sb.toString();
	}
}