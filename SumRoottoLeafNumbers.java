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
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    
    private int helper(TreeNode root, int val) {
        if(root == null) return 0;
        int sum = 10 * val + root.val;
        if(root.left == null && root.right == null) return sum;
        return helper(root.left, sum) + helper(root.right, sum);
    }
}