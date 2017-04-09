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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        if(root == null) return ret;
        helper(root, "", ret);
        return ret;
    }
    
    private void helper(TreeNode root, String str, List<String> ret) {
        if(root.left == null && root.right == null) {
            ret.add(str + root.val);
            return;
        }
        str += root.val + "->";
        if(root.left != null) helper(root.left, str, ret);
        if(root.right != null) helper(root.right, str, ret);
    }
}