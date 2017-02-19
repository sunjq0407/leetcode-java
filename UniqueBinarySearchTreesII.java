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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        return helper(1, n);
    }
    
    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> ret = new ArrayList<>();
        if(start > end) {
            ret.add(null);
            return ret;
        }
        for(int i = start; i <= end; i++) {
            List<TreeNode> leftHeads = helper(start, i - 1);
            List<TreeNode> rightHeads = helper(i + 1, end);
            for(TreeNode left : leftHeads) {
                for(TreeNode right : rightHeads) {
                    TreeNode head = new TreeNode(i);
                    head.left = left;
                    head.right = right;
                    ret.add(head);
                }
            }
        }
        return ret;
    }
}