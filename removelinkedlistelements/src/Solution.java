/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head!=null&&head.val == val) head = head.next;
        if (head==null) return null;
        ListNode node = head, prev = head;
        while (node!=null) {
            if (node.val == val)
                prev.next = node.next;
            else prev = node;
            node = node.next;
        }
        return head;
    }
}