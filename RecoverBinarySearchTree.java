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
    public void recoverTree(TreeNode root) {
        TreeNode[] nodes = new TreeNode[3];
        nodes[2] = new TreeNode(Integer.MIN_VALUE);
        helper(root, nodes);
        int tmp = nodes[0].val;
        nodes[0].val = nodes[1].val;
        nodes[1].val = tmp;
    }
    
    private void helper(TreeNode root, TreeNode[] nodes) {
        if(root == null) return;
        helper(root.left, nodes);
        if (nodes[0] == null && root.val < nodes[2].val) nodes[0] = nodes[2];
        if (nodes[0] != null && root.val < nodes[2].val) nodes[1] = root;
        nodes[2] = root;
        helper(root.right, nodes);
    }
}