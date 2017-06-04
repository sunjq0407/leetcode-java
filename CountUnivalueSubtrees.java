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
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return 0;
        int[] cnt = new int[1];
        helper(root, cnt);
        return cnt[0];
    }
    
    private boolean helper(TreeNode root, int[] cnt) {
        if(root.left == null && root.right == null) {
            cnt[0] ++;
            return true;
        }
        boolean left = root.left == null
                || helper(root.left, cnt) && root.val == root.left.val;
        boolean right = root.right == null
                || helper(root.right, cnt) && root.val == root.right.val;
        if(left && right) {
            cnt[0] ++;
            return true;
        }
        return false;
    }
}