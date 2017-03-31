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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int cnt = 0;
        while(root != null || !stack.empty()) {
            if(root != null) {
                stack.push(root);
                root = root.left;
                continue;
            } 
            root = stack.pop();
            cnt++;
            if(cnt == k) return root.val;
            root = root.right;
        }
        return -1;
    }
}