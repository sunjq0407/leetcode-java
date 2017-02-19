/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while(head != null) {
            if(head.next == null || head.val != head.next.val) {
                prev.next = head;
                prev = prev.next;
            }
            while(head.next != null && head.val == head.next.val) 
                head = head.next;
            head = head.next;
        }
        prev.next = null;
        return dummy.next;
    }
}