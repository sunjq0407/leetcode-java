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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return same (root.left, root.right);
    }
    public boolean same (TreeNode A, TreeNode B) {
        if (A==null&&B==null) return true;
        if ((A==null&&B!=null)||(A!=null&&B==null)) return false;
        if (A.val == B.val)
            return same(A.left, B.right)&&same(A.right, B.left);
        else return false;
    }
}