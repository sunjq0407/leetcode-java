public class Solution {
    public String addBinary(String a, String b) {
        char[] x = a.toCharArray();
        char[] y = b.toCharArray();
        int[] ret = new int[a.length()+b.length()];
        String s = "";
        int j;
        for (int i=1; i<ret.length; i++) {
            if (i<=x.length) ret[ret.length-i] += x[x.length-i] - '0';
            if (i<=y.length) ret[ret.length-i] += y[y.length-i] - '0';
            ret[ret.length-i-1] += ret[ret.length-i]/2;
            ret[ret.length-i] %= 2;
        }
        for (j=0; j<ret.length; j++)
            if (ret[j]!=0) break;
        for (; j<ret.length; j++)
            s += ret[j];
        if (s == "") s = "0";
        return s;
    }
}