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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        putin (root, ret, 0);
        return ret;
    }
    private void putin (TreeNode node, List<List<Integer>> ret, int level) {
        if (node == null) return;
        if (ret.size() == level) ret.add (new ArrayList<Integer>());
        ret.get(level).add(node.val);
        putin (node.left, ret, level+1);
        putin (node.right, ret, level+1);
    }
}