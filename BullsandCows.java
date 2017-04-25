public class Solution {
    public String getHint(String secret, String guess) {
        int[] num = new int[10];
        int a = 0;
        int b = 0;
        for(int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if(s == g) a++;
            else {
                if(num[s] < 0) b++;
                if(num[g] > 0) b++;
                num[s] ++;
                num[g] --;
            }
        }
        return a + "A" + b + "B";
    }
}