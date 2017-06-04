public class Solution {
    
    private class SegNode {
        int val;
        int start;
        int end;
        SegNode left;
        SegNode right;
        
        public SegNode(int start, int end) {
            this.start = start;
            this.end = end;
            val = 0;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums.length == 0) return list;
        int min = nums[0];
        int max = nums[0];
        for(int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        SegNode root = build(min - 1, max);
        for(int i = nums.length - 1; i >= 0; i--) {
            modify(root, nums[i]);
            list.add(query(root, min - 1, nums[i] - 1));
        }
        Collections.reverse(list);
        return list;
    }
    
    public SegNode build(int start, int end) {
        if(start == end) return new SegNode(start, end);
        SegNode root = new SegNode(start, end);
        int mid = start >= 0 ? (end + start) / 2 : (end + start - 1) / 2;
        root.left = build(start, mid);
        root.right = build(mid + 1, end);
        return root;
    }
    
    public void modify(SegNode root, int num) {
        if(root.start == root.end && root.start == num) {
            root.val++;
            return;
        }
        int mid = root.start >= 0 ? (root.end + root.start) / 2 : (root.end + root.start - 1) / 2;
        if(num <= mid) modify(root.left, num);
        else modify(root.right, num);
        root.val = root.left.val + root.right.val;
    }
    
    public int query(SegNode root, int start, int end) {
        if(root.start == start && root.end == end) return root.val;
        int mid = root.start >= 0 ? (root.end + root.start) / 2 : (root.end + root.start - 1) / 2;
        if(end <= mid) return query(root.left, start, end);
        if(end > mid && start <= mid)
            return query(root.left, start, mid) + query(root.right, mid + 1, end);
        return query(root.right, start, end);
    }
}