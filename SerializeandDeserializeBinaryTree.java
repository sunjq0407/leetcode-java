/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "null";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node == null) sb.append("null,");
            else {
                sb.append(node.val + ",");
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        while(sb.length() >= 4 && sb.substring(sb.length() - 4, sb.length()).equals("null"))
            sb.delete(sb.length() - 5, sb.length());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("null")) return null;
        int id = 0;
        for(; id < data.length(); id++)
            if(data.charAt(id) == ',') break;
        TreeNode head = new TreeNode(Integer.parseInt(data.substring(0, id++)));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(head);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            boolean isLeft = true;
            for(int i = 0; i < 2; i++) {
                if(id >= data.length()) break;
                int prev = id;
                for(; id < data.length(); id++)
                    if(data.charAt(id) == ',') break;
                String str = data.substring(prev, id++);
                if(str.equals("null")) {
                    if(isLeft) node.left = null;
                    else node.right = null;
                } else {
                    TreeNode child = new TreeNode(Integer.parseInt(str));
                    q.offer(child);
                    if(isLeft) node.left = child;
                    else node.right = child;
                }
                isLeft = !isLeft;
            }
        }
        return head;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));