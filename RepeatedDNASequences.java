public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> ret = new HashSet<>();
        for(int i = 0; i + 10 <= s.length(); i++) {
            String str = s.substring(i, i + 10);
            if(set.contains(str))
                ret.add(str);
            set.add(str);
        }
        return new ArrayList<>(ret);
    }
}