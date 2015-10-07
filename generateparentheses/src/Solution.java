import java.util.*;
public class Solution {
    public List<String> generateParenthesis(int n) {return helper(0,n);}
    private List<String> helper(int count, int n) {
        List ret = new ArrayList<String>();
        if (count==0&&n==0) {
            ret.add("");
            return ret;
        }
        if (count<n) for(String str : helper(count+1, n)) ret.add("("+str);
        if (n>0&&count>0) for(String str : helper(count-1, n-1)) ret.add(")"+str);
        return ret;
    }
}