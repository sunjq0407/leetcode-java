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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode ret = null;
        while(root != null && root != p) {
            if(root.val > p.val) {
                ret = root;
                root = root.left;
            } else root = root.right;
        }
        if(root == null) return null;
        if(root.right == null) return ret;
        root = root.right;
        while(root.left != null) root = root.left;
        return root;
    }
}