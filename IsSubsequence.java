class Solution {
    public boolean isSubsequence(String s, String t) {
        int id = 0;
        for(int i = 0; i < t.length(); i++) {
            if(id == s.length()) {
                return true;
            }
            if(t.charAt(i) == s.charAt(id)) {
                id ++;
            }
        }
        return id == s.length();
    }
}