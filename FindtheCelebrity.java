/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        boolean[] notCel = new boolean[n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                if(knows(i, j)) notCel[i] = true;
                else notCel[j] = true;
                if(knows(j, i)) notCel[j] = true;
                else notCel[i] = true;
            }
        }
        int ret = -1;
        for(int i = 0; i < n; i++) if(!notCel[i]) ret = i;
        return ret;
    }
}