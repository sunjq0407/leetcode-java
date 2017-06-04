public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ret = new ArrayList<>();
        for(String str : strings) {
            boolean found = false;
            for(List<String> list : ret) {
                if(group(str, list.get(0))) {
                    found = true;
                    list.add(str);
                }
            }
            if(!found) {
                List<String> list = new ArrayList<>();
                list.add(str);
                ret.add(list);
            }
        }
        return ret;
    }
    
    private boolean group(String a, String b) {
        if(a.length() != b.length()) return false;
        int offset = a.charAt(0) - b.charAt(0);
        for(int i = 1; i < a.length(); i++)
            if((b.charAt(i) + offset - 'a' + 26) % 26 + 'a' != a.charAt(i))
                return false;
        return true;
    }
}