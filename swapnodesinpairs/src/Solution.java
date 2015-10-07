/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode init = new ListNode(0);
        ListNode ret = head.next;
        init.next = head;
        helper(head, init);
        return ret;
    }
    private void helper(ListNode node, ListNode prev) {
        ListNode tmp = null;
        if (node.next.next!=null) tmp = node.next.next;
        prev.next = node.next;
        node.next.next = node;
        node.next = tmp;
        if (node.next!=null&&node.next.next!=null) helper(node.next, node);
        return;
    }
