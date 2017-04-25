public class NumArray {
    
    private class SegNode {
        int start;
        int end;
        SegNode left;
        SegNode right;
        int sum;
        public SegNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    SegNode root;

    public NumArray(int[] nums) {
        if(nums.length == 0) return;
        root = build(0, nums.length - 1, nums);
    }
    
    public void update(int i, int val) {
        modify(root, i, val);
    }
    
    public int sumRange(int i, int j) {
        return query(root, i, j);
    }
    
    private SegNode build(int start, int end, int[] nums) {
        SegNode node = new SegNode(start, end);
        if(start == end) {
            node.sum = nums[start];
            return node;
        }
        int mid = (end - start) / 2 + start;
        SegNode left = build(start, mid, nums);
        SegNode right = build(mid + 1, end, nums);
        node.left = left;
        node.right = right;
        node.sum = left.sum + right.sum;
        return node;
    }
    
    private void modify(SegNode node, int i, int val) {
        if(node.start == node.end && node.start == i) {
            node.sum = val;
            return;
        }
        int mid = (node.start + node.end) / 2;
        if(i <= mid) modify(node.left, i, val);
        else modify(node.right, i, val);
        node.sum = node.left.sum + node.right.sum;
    }
    
    private int query(SegNode node, int start, int end) {
        if(node.start == start && node.end == end) return node.sum;
        int mid = (node.start + node.end) / 2;
        int ret = 0;
        if(start <= mid) ret += query(node.left, start, Math.min(mid, end));
        if(end > mid) ret += query(node.right, Math.max(mid + 1, start), end);
        return ret;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */