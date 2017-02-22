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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q1.offer(root);
        q2.offer(root.val);
        while(!q1.isEmpty()) {
            int size = q1.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = q1.poll();
                int s = q2.poll();
                if(node.left == null && node.right == null && s == sum)
                    return true;
                if(node.left != null) {
                    q1.offer(node.left);
                    q2.offer(s + node.left.val);
                }
                if(node.right != null) {
                    q1.offer(node.right);
                    q2.offer(s + node.right.val);
                }
            }
        }
        return false;
    }
}