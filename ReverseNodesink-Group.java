/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(head != null) {
            ListNode last = head;
            for(int i = 0; i < k; i++) {
                if(last.next == null) return dummy.next;
                last = last.next;
            }
            ListNode first = head.next;
            ListNode next = last.next;
            ListNode prev = first;
            ListNode node = prev.next;
            for(int i = 0; i < k - 1; i++) {
                ListNode tmp = node.next;
                node.next = prev;
                prev = node;
                node = tmp;
            }
            head.next = last;
            first.next = next;
            head = first;
        }
        return dummy.next;
    }
}