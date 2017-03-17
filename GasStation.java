public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] gas2 = new int[gas.length * 2];
        int[] cost2 = new int[cost.length * 2];
        for(int i = 0; i < gas.length; i++) {
            gas2[i] = gas[i];
            gas2[i + gas.length] = gas[i];
            cost2[i] = cost[i];
            cost2[i + cost.length] = cost[i];
        }
        for(int i = 0; i < gas.length; i++) {
            int g = 0;
            int j = i;
            for(; j < i + gas.length; j++) {
                g += gas2[j] - cost2[j];
                if(g < 0) break;
            }
            if(j == i + gas.length && g >= 0) return i;
        }
        return -1;
    }
}