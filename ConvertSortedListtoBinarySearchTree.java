/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    
    ListNode cur;
    
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        cur = head;
        int size = 0;
        while(head != null) {
            head = head.next;
            size ++;
        }
        return helper(head, size);
    }
    
    private TreeNode helper(ListNode head, int size) {
        if(size == 0) return null;
        TreeNode left = helper(head, size / 2);
        TreeNode node = new TreeNode(cur.val);
        cur = cur.next;
        TreeNode right = helper(head, size - size / 2 - 1);
        node.left = left;
        node.right = right;
        return node;
    }
}