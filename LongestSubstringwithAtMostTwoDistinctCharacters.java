public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() <= 2) return s.length();
        char[] arr = s.toCharArray();
        int start = 0;
        int lastDup = 0;
        int max = 1;
        char a = arr[0];
        char b = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != a && a == b) b = arr[i];
            else if(arr[i] != a && arr[i] != b) {
                start = lastDup;
                a = arr[lastDup];
                b = arr[i];
            }
            if(arr[i] != arr[i - 1]) lastDup = i;
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}