public class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int l = 0;
        int r = s.length() - 1;
        while(l < r) {
            while(l < r && !isVowel(arr[l])) l++;
            while(l < r && !isVowel(arr[r])) r--;
            char c = arr[l];
            arr[l++] = arr[r];
            arr[r--] = c;
        }
        return new String(arr);
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}