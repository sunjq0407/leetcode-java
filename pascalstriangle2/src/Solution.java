import java.util.*;
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        int half = rowIndex / 2; 
        long cur = 1;
        result.add((int)(cur));
        for(int i = 1; i <= half; i++) {  
            cur = cur * (rowIndex - i + 1) / i;
            result.add((int)(cur));
        }
        if(rowIndex % 2 == 0) half -= 1;
        for(int i = half; i >= 0; i--) result.add(result.get(i));
        return result;
    }
}