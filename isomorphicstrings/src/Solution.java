public class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] str1 = s.toCharArray(), str2 = t.toCharArray();
        int i=0, j=0, q=0;
        for (i=0; i<str1.length; i++) {
            for (j=0; j<i; j++) if (str1[j] == str1[i]) break;
            q = j;
            for (j=0; j<i; j++) if (str2[j] == str2[i]) break;
            if (q!=j) return false;
        }
        return true;
    }
}