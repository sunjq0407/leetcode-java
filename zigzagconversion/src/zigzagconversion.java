import java.util.*;
class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        int numCols = (numRows-1) * (s.length()/(2*numRows-2)+1);
        char[][] matrix = new char[numCols][numRows];
        char[] str = s.toCharArray();
        boolean dirct = false;
        int row = 0, col = 0;
        for(char c : str){
            matrix[col][row] = c;
            if(row == 0) dirct = false;
            if(row == numRows -1) dirct = true;
            if(dirct) {row--; col++;}
            if(!dirct) row++;
        }
        String ret = "";
        for(int i=0; i<numRows; i++)
            for(int j=0; j<numCols; j++)
                if(matrix[j][i]!=0) ret += matrix[j][i];
        return ret;
    }
}
public class zigzagconversion {
	public static void main(String[] args){
		Solution solution = new Solution();
		String prt = solution.convert("ABC", 3);
		System.out.println(prt);
    }
}