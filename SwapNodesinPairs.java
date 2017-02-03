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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(head.next != null && head.next.next != null) {
            ListNode next = head.next.next.next;
            ListNode node = head.next.next;
            node.next = head.next;
            head.next.next = next;
            head.next = node;
            head = head.next.next;
        }
        return dummy.next;
    }
}