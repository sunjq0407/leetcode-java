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
    
    TreeNode cur;
    
    public void flatten(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        cur = dummy;
        helper(root);
    }
    
    private void helper(TreeNode root) {
        if(root == null) return;
        cur.right = root;
        cur = cur.right;
        TreeNode right = root.right;
        helper(root.left);
        helper(right);
        root.left = null;
    }
}