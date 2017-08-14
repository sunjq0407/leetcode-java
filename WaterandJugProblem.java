public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        return (x == z || y == z || x + y == z
                || (x + y > z && z % GCD(x, y) == 0));
    }
    
    public int GCD(int a, int b) {
        while(b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}