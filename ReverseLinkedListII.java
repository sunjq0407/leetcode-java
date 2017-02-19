/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m == n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for(int i = 1; i < m; i++) prev = prev.next;
        head = prev.next;
        ListNode next = head.next;
        for(int i = m; i < n; i++) {
            ListNode tmp = next.next;
            next.next = head;
            head = next;
            next = tmp;
        }
        prev.next.next = next;
        prev.next = head;
        return dummy.next;
    }
}