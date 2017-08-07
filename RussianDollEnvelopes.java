public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (env1, env2) -> env1[0] != env2[0] ?
                    env1[0] - env2[0] : env2[1] - env1[1]);
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int[] env : envelopes) {
            int idx = Arrays.binarySearch(dp, env[1]);
            if(idx < 0) {
                idx = -idx - 1;
            }
            dp[idx] = env[1];
        }
        for(int i = dp.length - 1; i >= 0; i--) {
            if(dp[i] != Integer.MAX_VALUE) {
                return i + 1;
            }
        }
        return 0;
    }
}