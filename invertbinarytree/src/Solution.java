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
    public TreeNode invertTree(TreeNode root) {
        inverse(root);
        return root;
    }
    private void inverse(TreeNode node) {
        if (node == null) return;
        TreeNode tmp = null;
        tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        inverse(node.left);
        inverse(node.right);
    }
}