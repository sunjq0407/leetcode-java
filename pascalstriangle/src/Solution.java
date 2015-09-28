import java.util.*;
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (numRows==0) return ret;
        List<Integer> row0= new ArrayList<Integer>();
        row0.add(1);
        ret.add(row0);
        if (numRows == 1)  return ret;
        List<Integer> row1= new ArrayList<Integer>();
        row1.add(1); row1.add(1);
        ret.add(row1);
        if (numRows == 2)  return ret;
        for (int i = 2; i < numRows; i++)  {
            List<Integer> newRow= new ArrayList<Integer>();
            newRow.add(1);
            for (int j = 1; j< i; j++)
                newRow.add(ret.get(i-1).get(j-1) + ret.get(i-1).get(j));
            newRow.add(1);
            ret.add(newRow);
        }
    return ret;
    }
}