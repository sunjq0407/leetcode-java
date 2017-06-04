public class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] father = new int[n];
        for(int i = 0; i < n; i++) father[i] = i;
        for(int[] edge : edges) {
            int x = find(edge[0], father);
            int y = find(edge[1], father);
            if(x == y) return false;
            father[y] = x;
        }
        return edges.length == n - 1;
    }
    
    private int find(int x, int[] father) {
        int parent = father[x];
        while(parent != father[parent]) parent = father[parent];
        while(x != parent) {
            int next = father[x];
            father[x] = parent;
            x = next;
        }
        return parent;
    }
}