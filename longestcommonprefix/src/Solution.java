public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int min_length = strs[0].length();
        for(int a=0; a<strs.length; a++){
            if(strs[a].length()<min_length) min_length = strs[a].length();
        }
        if(min_length==0) return "";
        String ret = "";
        boolean sign = false;
        for(int i=0; i<min_length; i++){
            for(int j=0; j<strs.length; j++){
                if(strs[j].charAt(i)!=strs[0].charAt(i)) {
                    sign = true;
                    break;
                }
            }
            if (sign) break;
            ret += strs[0].charAt(i);
        }
        return ret;
    }
}