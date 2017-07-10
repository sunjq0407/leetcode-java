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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<TreeNode, Integer> valueMap = new HashMap<>();
        int min = 0;
        int max = 0;
        valueMap.put(root, 0);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int val = valueMap.get(node);
            System.out.println(val + " " + node.val);
            map.putIfAbsent(val, new ArrayList<>());
            map.get(val).add(node.val);
            if(node.left != null) {
                queue.offer(node.left);
                valueMap.put(node.left, val - 1);
                min = Math.min(min, val - 1);
            }
            if(node.right != null) {
                queue.offer(node.right);
                valueMap.put(node.right, val + 1);
                max = Math.max(max, val + 1);
            }
        }
        for(int i = min; i <= max; i++)
            ret.add(map.get(i));
        return ret;
    }
}