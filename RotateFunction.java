class Solution {
    public int maxRotateFunction(int[] A) {
        int fun = 0;
        int sum = 0;
        for(int i = 0; i < A.length; i++) {
            fun += i * A[i];
            sum += A[i];
        }
        int ret = fun;
        for(int i = 1; i < A.length; i++) {
            fun += sum - A.length * A[A.length - i];
            ret = Math.max(ret, fun);
        }
        return ret;
    }
}