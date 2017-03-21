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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) return ret;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode cur = root;
        stack.push(root);
        while(!stack.empty()) {
            cur = stack.peek();
            if(prev == null || prev.left == cur || prev.right == cur) {
                if(cur.left != null) stack.push(cur.left);
                else if(cur.right != null) stack.push(cur.right);
            } else if(prev == cur.left) {
                if(cur.right != null) stack.push(cur.right);
            } else {
                ret.add(cur.val);
                stack.pop();
            }
            prev = cur;
        }
        return ret;
    }
}