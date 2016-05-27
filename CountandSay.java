public class Solution {
    public String countAndSay(int n) {
        String result = "1";
        while(--n > 0) result = helper(result);
        return result;
    }
    
    private String helper(String str){
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i = 0; i < str.length(); i++){
            if(i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) count++;
            else {
                sb.append(count).append(str.charAt(i));
                count=1;
            }
        }
        return sb.toString();
    }
}