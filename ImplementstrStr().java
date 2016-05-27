public class Solution {
    public int strStr(String haystack, String needle) {
        return kmp(haystack.toCharArray(), needle.toCharArray());
    }
    
    public static int[] buildTable(char[] W) {
        int[] table = new int[W.length];
        int i = 2;
        int val = 0;
        table[0] = -1; 
        while(i < W.length) {
            if(W[i - 1] == W[val]) table[i++] = ++val;
            else if(val > 0) val = table[val];
            else table[i++] = 0;
        }
        return table;
    }
	
	public static int kmp(char[] S, char[] W) {
        if(W.length == 0) return 0;
        if(S.length == 0) return -1;
        int m = 0;
        int i = 0;
        int[] T = buildTable(W);

        while(m + i < S.length) {
            if(W[i] == S[m + i]) {
                if(i++ == W.length - 1) return m;
            } else {
                m += i - T[i];
                i = T[i] > -1 ? T[i] : 0;
            }
        }
        return -1;
    }
}