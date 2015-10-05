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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ret = root;
        while (true) {
            if (p.val==ret.val||q.val==ret.val
                ||(p.val>ret.val&&q.val<ret.val)
                ||(p.val<ret.val&&q.val>ret.val))
                return ret;
            else if (p.val<ret.val&&q.val<ret.val) ret = ret.left;
            else if (p.val>ret.val&&q.val>ret.val) ret = ret.right;
            else break;
        }
        return ret;
    }
}