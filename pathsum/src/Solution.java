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
    public boolean hasPathSum(TreeNode root, int sum) {
        return CalSum(root, 0, sum);
    }
    private boolean CalSum(TreeNode node, int cur, int sum) {
        if (node==null) return false;
        if (node.left==null&&node.right==null&&cur+node.val==sum)
            return true;
        else return CalSum(node.left, cur+node.val, sum)
                    ||CalSum(node.right, cur+node.val, sum);
    }
}