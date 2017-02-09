public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int[] step = new int[n + 1];
        int num = 1;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 1; i <= n; i++) {
            step[i] = num;
            num *= i;
            set.add(i);
        }
        k--;
        for(int i = n; i >= 1; i--) {
            num = k / step[i];
            k %= step[i];
            for(int j = 1; j <= n; j++) {
                if(set.contains(j)) {
                    if(num == 0) {
                        sb.append(j);
                        set.remove(j);
                        break;
                    } else num --;
                }
            }
        }
        return sb.toString();
    }
}