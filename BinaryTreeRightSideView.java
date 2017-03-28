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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) return ret;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            ret.add(q.peek().val);
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(node.right != null) q.offer(node.right);
                if(node.left != null) q.offer(node.left);
            }
        }
        return ret;
    }
}