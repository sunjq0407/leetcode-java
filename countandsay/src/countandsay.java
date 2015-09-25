class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String ret = "1";
        String seq = "";
        int count = 0;
        char prev = '\0';
        for (int i=1; i<n; i++) {
            for (char c : ret.toCharArray()) {
                ret = "";
                if (c == prev) {
                    count ++;
                    continue;
                }
                else if (prev != '\0') {
                    seq += count;
                    seq += prev;
                }
                count = 1;
                prev = c;
            }
            if (count != 0) {
                seq += count;
                seq += prev;
            }
            count = 0;
            prev = '\0';
            ret = seq;
            seq = "";
        }
        return ret;
    }
}
public class countandsay {
	public static void main (String[] args) {
		Solution solution = new Solution();
		System.out.println (solution.countAndSay(5));
	}
}