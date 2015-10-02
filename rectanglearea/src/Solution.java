public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int x1 = Math.max(A,E);
        int x2 = Math.min(C,G);
        int y1 = Math.max(B,F);
        int y2 = Math.min(D,H);
        if(x2>=x1&&y2>=y1) return (C-A)*(D-B)+(G-E)*(H-F)-(x2-x1)*(y2-y1);
        else return (C-A)*(D-B)+(G-E)*(H-F);
    }
}