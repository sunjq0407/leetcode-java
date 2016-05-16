public class Solution {
    // from http://www.jiuzhang.com/solutions/zigzag-conversion/
    public String convert(String s, int numRows) {
        int length = s.length();
        if (length <= numRows || numRows <= 1) return s;
        char[] chars = new char[length];
        // step: number of chars in one loop
        int step = 2 * (numRows - 1);
        int count = 0;
	    for (int i = 0; i < numRows; i++) {
	        // i: current row number
	        // interval: distance of the two chars in row[i] (if exist)
	        /*
	            *      
	            x     x  
	            *   *
	            * *
	            *
	        */
    		int interval = step - 2 * i;
    		for (int j = i; j < length; j += step){
    		   	chars[count++] = s.charAt(j);
    			if (interval < step && interval > 0 && j + interval < length && count <  length)
    				chars[count++] = s.charAt(j + interval);
    		}
    	}
        return new String(chars);
    }
}