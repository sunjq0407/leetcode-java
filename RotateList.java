/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        int len = 1;
        while(fast.next != null) {
            fast = fast.next;
            len ++;
        }
        fast = head;
        k %= len;
        if(k == 0) return head;
        for(int i = 0; i < k; i++) fast = fast.next;
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = head;
        ListNode ret = slow.next;
        slow.next = null;
        return ret;
    }
}