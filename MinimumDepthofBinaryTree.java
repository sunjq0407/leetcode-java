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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int ret = Integer.MAX_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            level ++;
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null)
                    ret = Math.min(ret, level);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return ret;
    }
}