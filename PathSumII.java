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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        helper(root, sum, root.val, list, ret);
        return ret;
    }
    
    private void helper(TreeNode root, int sum, int s, List<Integer> list,
            List<List<Integer>> ret) {
        if(root.left == null && root.right == null && s == sum) {
            ret.add(new ArrayList<>(list));
            return;
        }
        if(root.left != null) {
            list.add(root.left.val);
            helper(root.left, sum, s + root.left.val, list, ret);
            list.remove(list.size() - 1);
        }
        if(root.right != null) {
            list.add(root.right.val);
            helper(root.right, sum, s + root.right.val, list, ret);
            list.remove(list.size() - 1);
        }
    }
}