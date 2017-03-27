public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        boolean neg = numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0;
        long nu = Math.abs((long)numerator);
        long de = Math.abs((long)denominator);
        long d = nu / de;
        nu = nu % de * 10;
        String f = "";
        int start = -1;
        HashMap<Long, Integer> map = new HashMap<>();
        while(nu != 0) {
            f += nu / de;
            map.put(nu, f.length() - 1);
            nu = nu % de * 10;
            if(map.containsKey(nu)) {
                start = map.get(nu);
                break;
            }
        }
        String ret = neg ? "-" + d : "" + d;
        if(f.length() != 0) ret += ".";
        if(start == -1) return ret + f;
        return ret + f.substring(0, start) + "(" + f.substring(start) + ")";
    }
}