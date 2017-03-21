/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast.next != null) fast = fast.next;
        ListNode prev = slow;
        ListNode cur = slow.next;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        slow.next = null;
        ListNode l1 = head;
        ListNode l2 = fast;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(l1 != null && l2 != null) {
            ListNode next1 = l1.next;
            ListNode next2 = l2.next;
            head.next = l1;
            head.next.next = l2;
            l1 = next1;
            l2 = next2;
            head = head.next.next;
        }
        if(l1 != null) {
            head.next = l1;
            head = head.next;
        }
        head.next = null;
    }
}