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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.empty()) {
            if(root != null) {
                ret.add(root.val);
                if(root.right != null) stack.push(root.right);
                root = root.left;
            } else root = stack.pop();
        }
        return ret;
    }
}