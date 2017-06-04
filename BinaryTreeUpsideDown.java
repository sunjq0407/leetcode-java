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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null) return null;
        TreeNode node = root;
        while(node.left != null) node = node.left;
        helper(root);
        return node;
    }
    
    private void helper(TreeNode root) {
        if(root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(left == null && right == null) return;
        helper(left);
        helper(right);
        left.left = right;
        left.right = root;
        root.left = null;
        root.right = null;
    }
}