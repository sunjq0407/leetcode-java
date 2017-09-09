class Solution {
    public char findTheDifference(String s, String t) {
        int i = 0;
        for(char c : s.toCharArray()) {
            i ^= (int)c;
        }
        for(char c : t.toCharArray()) {
            i ^= (int)c;
        }
        return (char)i;
    }
}