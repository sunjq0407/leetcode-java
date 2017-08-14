public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int ret = Integer.MIN_VALUE;
        // Assume number of rows is much larger than the number of columns
        for(int i = 0; i < matrix[0].length; i++) {
            int[] sums = new int[matrix.length];
            for(int j = i; j < matrix[0].length; j++) {
                TreeSet<Integer> tree = new TreeSet<>();
                int sum = 0;
                tree.add(0);
                for(int p = 0; p < matrix.length; p++) {
                    sums[p] += matrix[p][j];
                    sum += sums[p];
                    Integer tmp = tree.ceiling(sum - k);
                    if(tmp != null) {
                        ret = Math.max(ret, sum - tmp);
                    }
                    tree.add(sum);
                }
            }
        }
        return ret;
    }
}