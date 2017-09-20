class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> nums = new Stack<>();
        Stack<String> strs = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                int j = i;
                while(Character.isDigit(s.charAt(j))) {
                    j ++;
                }
                int n = Integer.parseInt(s.substring(i, j));
                i = j;
                nums.push(n);
                strs.push(sb.toString());
                sb = new StringBuilder();
            } else if(s.charAt(i) == ']') {
                String str = sb.toString();
                sb = new StringBuilder();
                int k = nums.pop();
                for(int j = 0; j < k; j++) {
                    sb.append(str);
                }
                sb.insert(0, strs.pop());
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}