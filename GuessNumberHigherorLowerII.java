class Solution {
    public int getMoneyAmount(int n) {
        int[][] f = new int[n + 1][n + 1];
        for(int i = 1; i < n; i++) {
            for(int j = 0; j + i <= n; j++) {
                f[j][j + i] = Integer.MAX_VALUE;
                for(int k = j; k <= j + i; k++) {
                    f[j][j + i] = Math.min(f[j][j + i],
                            k + Math.max(k > j ? f[j][k - 1] : 0,
                                     k < j + i ? f[k + 1][j + i] : 0));
                }
            }
        }
        return f[1][n];
    }
}