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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] pre, int[] in, int pl, int pr, int il, int ir) {
        if(pl < 0 || pr >= pre.length || pl > pr
                || il < 0 || ir >= in.length || il > ir) return null;
        TreeNode root = new TreeNode(pre[pl]);
        int i = il;
        for(; i <= ir; i++) if(in[i] == root.val) break;
        root.left = helper(pre, in, pl + 1, pl + i - il , il, i - 1);
        root.right = helper(pre, in, pl + i - il + 1, pr, i + 1, ir);
        return root;
    }
}