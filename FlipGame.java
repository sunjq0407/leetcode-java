public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> ret = new ArrayList<>();
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] == '+' && arr[i + 1] == '+') {
                arr[i] = '-';
                arr[i + 1] = '-';
                ret.add(String.valueOf(arr));
                arr[i] = '+';
                arr[i + 1] = '+';
            }
        }
        return ret;
    }
}