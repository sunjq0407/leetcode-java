public class Solution {
    public boolean canWin(String s) {
        char[] arr = s.toCharArray();
        return helper(arr);
    }
    
    public boolean helper (char[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] == '+' && arr[i + 1] == '+') {
                arr[i] = '-';
                arr[i + 1] = '-';
                if(!helper(arr)) {
                    arr[i] = '+';
                    arr[i + 1] = '+';
                    return true;
                }
                arr[i] = '+';
                arr[i + 1] = '+';
            }
        }
        return false;
    }
}