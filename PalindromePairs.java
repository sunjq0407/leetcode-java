public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ret = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) map.put(words[i], i);
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j <= words[i].length(); j++) {
                String pre = words[i].substring(0, j);
                String suf = words[i].substring(j);
                if(isPalindrome(pre)) {
                    String sufRev = new StringBuilder(suf).reverse().toString();
                    if(map.containsKey(sufRev) && map.get(sufRev) != i)
                        ret.add(Arrays.asList(map.get(sufRev), i));
                }
                if(isPalindrome(suf)) {
                    String preRev = new StringBuilder(pre).reverse().toString();
                    if(map.containsKey(preRev) && map.get(preRev) != i && suf.length() != 0)
                        ret.add(Arrays.asList(i, map.get(preRev)));
                }
            }
        }
        return ret;
    }
    
    private boolean isPalindrome(String str) {
        for(int i = 0; i < str.length() / 2; i++)
            if(str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        return true;
    }
}