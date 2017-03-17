public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        UnionFind uf = new UnionFind();
        for(int i : nums) {
            if(!uf.father.containsKey(i)) uf.father.put(i, i);
            if(uf.father.containsKey(i - 1)) uf.union(i, i - 1);
            if(uf.father.containsKey(i + 1)) uf.union(i, i + 1);
        }
        int ret = 0;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for(int i : uf.father.keySet()) {
            int father = uf.find(i);
            if(!cnt.containsKey(father)) cnt.put(father, 1);
            else cnt.put(father, cnt.get(father) + 1);
            ret = Math.max(ret, cnt.get(father));
        }
        return ret;
    }
    
    private class UnionFind {
        HashMap<Integer, Integer> father;
        public UnionFind() {
            father = new HashMap<>();
        }
        
        public int find(int x) {
            int parent = x;
            while(father.get(parent) != parent)
                parent = father.get(parent);
            while(x != parent) {
                int next = father.get(x);
                father.put(x, parent);
                x = next;
            }
            return parent;
        }
        
        public void union(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            if(fx != fy) father.put(fx, fy);
        }
    }
}