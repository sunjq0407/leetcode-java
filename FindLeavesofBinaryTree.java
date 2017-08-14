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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(root, ret);
        return ret;
    }
    
    private int dfs(TreeNode root, List<List<Integer>> ret) {
        if(root == null) {
            return -1;
        }
        int level = 1 + Math.max(dfs(root.left, ret), dfs(root.right, ret));
        if(ret.size() <= level) {
            ret.add(new ArrayList<>());
        }
        ret.get(level).add(root.val);
        return level;
    }
}