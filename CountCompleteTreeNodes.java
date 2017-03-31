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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int l = 0;
        int r = 0;
        TreeNode node = root;
        while(node != null) {
            node = node.left;
            l++;
        }
        node = root;
        while(node != null) {
            node = node.right;
            r++;
        }
        if(l == r) return (1 << l) - 1;
        else return 1 + countNodes(root.left) + countNodes(root.right);
    }
}