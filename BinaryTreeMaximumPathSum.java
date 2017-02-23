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
    
    int max;
    
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        max = Integer.MIN_VALUE;
        helper(root);
        return max;
    }
    
    private int helper(TreeNode root) {
        if(root == null) return 0;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        max = Math.max(max, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}