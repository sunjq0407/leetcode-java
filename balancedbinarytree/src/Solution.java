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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return Math.abs(left - right) < 2 && isBalanced(root.left)
            && isBalanced(root.right);
    }
    private int treeDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(treeDepth(root.left), treeDepth(root.right));
    }
}