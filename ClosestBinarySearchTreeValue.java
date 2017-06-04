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
    public int closestValue(TreeNode root, double target) {
        int ret = root.val;
        while(root != null) {
            ret = Math.abs(ret - target) < Math.abs(root.val - target) ? ret : root.val;
            root = root.val > target ? root.left : root.right;
        }
        return ret;
    }
}