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
    public int longestConsecutive(TreeNode root) { 
        return root == null ? 0 : Math.max(helper(root.left, root.val, 1),
                helper(root.right, root.val, 1));
    }
    
    private int helper(TreeNode root, int val, int cnt) {
        if(root == null) return cnt;
        cnt = root.val - val == 1 ? cnt + 1 : 1;
        return Math.max(Math.max(helper(root.left, root.val, cnt),
                helper(root.right, root.val, cnt)), cnt);
    }
}