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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length != postorder.length) return null;
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    
    private TreeNode helper(int[] in, int[] post, int il, int ir, int pl, int pr) {
        if(il < 0 || ir >= in.length || il > ir || pl < 0 || pr >= post.length || pl > pr)
            return null;
        TreeNode root = new TreeNode(post[pr]);
        int pos = il;
        for(; pos <= ir; pos++) if(in[pos] == root.val) break;
        root.left = helper(in, post, il, pos - 1, pl, pl + pos - il - 1);
        root.right = helper(in, post, pos + 1, ir, pl + pos - il, pr - 1);
        return root;
    }
}