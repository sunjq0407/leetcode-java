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
    public int largestBSTSubtree(TreeNode root) {
        int ret = helper(root, -1, -1);
        if(ret >= 0) return ret;
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }
    
    private int helper(TreeNode root, int min, int max) {
        if(root == null) return 0;
        if((min != -1 && root.val <= min) || (max != -1 && root.val >= max)) return -1;
        int left = helper(root.left, min, root.val);
        int right = helper(root.right, root.val, max);
        return left < 0 || right < 0 ? -1 : left + right + 1;
    }
}