public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if(word1.equals(word2)) {
            int prev = -1;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < words.length; i++) {
                if(words[i].equals(word1)) {
                    if(prev == -1) prev = i;
                    else {
                        min = Math.min(min, i - prev);
                        prev = i;
                    }
                }
            }
            return min;
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i = 0; i < words.length; i++)
            if(words[i].equals(word1)) list1.add(i);
            else if(words[i].equals(word2)) list2.add(i);
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        while(i < list1.size() && j < list2.size()) {
            min = Math.min(min, Math.abs(list1.get(i) - list2.get(j)));
            if(list1.get(i) > list2.get(j)) j++;
            else i++;
        }
        return min;
    }
}