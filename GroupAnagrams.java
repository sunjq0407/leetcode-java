public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String s = String.valueOf(arr);
            if(!map.containsKey(s)) {
                List<String> l = new ArrayList<>();
                l.add(str);
                map.put(s, l);
            } else map.get(s).add(str);
        }
        for(String str : map.keySet()) ret.add(map.get(str));
        return ret;
    }
}