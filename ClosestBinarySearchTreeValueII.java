/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> ret = new ArrayList<>();
        Stack<Integer> small = new Stack<>();
        Stack<Integer> big = new Stack<>();
        inorder(root, target, true, small);
        inorder(root, target, false, big);
        for(int i = 0; i < k; i++) {
            if(small.empty()) ret.add(big.pop());
            else if(big.empty()) ret.add(small.pop());
            else ret.add(target - small.peek() <= big.peek() - target ? small.pop() : big.pop());
        }
        return ret;
    }
    
    private void inorder(TreeNode root, double target, boolean isSmall, Stack<Integer> stack) {
        if(root == null) return;
        inorder(isSmall ? root.left : root.right, target, isSmall, stack);
        if(isSmall && root.val > target || !isSmall && root.val <= target) return;
        stack.push(root.val);
        inorder(isSmall ? root.right : root.left, target, isSmall, stack);
    }
}