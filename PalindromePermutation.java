public class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        boolean odd = false;
        for(char c : map.keySet()) {
            if(map.get(c) % 2 != 0) {
                if(odd) return false;
                odd = true;
            }
        }
        return true;
    }
}