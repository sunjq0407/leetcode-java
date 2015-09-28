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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) return ret;
        Stack<List<Integer>> buffer = new Stack<List<Integer>>();
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        nodes.add (root);
        while (nodes.size()!=0) {
            int depth = nodes.size();
            List<Integer> level = new ArrayList<Integer>();
            while (depth!=0) {
                TreeNode tmp = nodes.poll();
                if (tmp.left != null) nodes.add (tmp.left);
                if (tmp.right != null) nodes.add (tmp.right);
                level.add (tmp.val);
                depth--;
            }
            buffer.push(level);
        }
        while (!buffer.empty()) ret.add (buffer.pop());
        return ret;
    }
}