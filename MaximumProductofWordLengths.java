public class Solution {
    public int maxProduct(String[] words) {
        if(words.length == 0) return 0;
        int max = 0;
        for(int i = 0; i < words.length; i++) {
            Set<Character> set = new HashSet<>();
            for(char c : words[i].toCharArray()) set.add(c);
            int len = words[i].length();
            for(int j = i + 1; j < words.length; j++) {
                if(len * words[j].length() <= max) continue;
                int k = 0;
                for(; k < words[j].length(); k++)
                    if(set.contains(words[j].charAt(k))) break;
                if(k == words[j].length()) max = Math.max(max, len * words[j].length());
            }
        }
        return max;
    }
}