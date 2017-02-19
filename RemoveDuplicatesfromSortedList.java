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
        while(head != null && head.next != null) {
            while(head.next != null && head.val == head.next.val) {
                prev.next = head.next;
                head = head.next;
            }
            head = head.next;
            prev = prev.next;
        }
        return dummy.next;
    }
}