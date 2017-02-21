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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        boolean leftToRight = false;
        while(!s.empty()) {
            int size = s.size();
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> tmp = new Stack<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = s.pop();
                list.add(node.val);
                if(!leftToRight) {
                    if(node.left != null) tmp.push(node.left);
                    if(node.right != null) tmp.push(node.right);
                } else {
                    if(node.right != null) tmp.push(node.right);
                    if(node.left != null) tmp.push(node.left);
                }
            }
            ret.add(list);
            s = tmp;
            leftToRight = !leftToRight;
        }
        return ret;
    }
}