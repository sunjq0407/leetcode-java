/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        head = reverse(head);
        ListNode node = head;
        ListNode prev = null;
        while(node != null) {
            if(node.val != 9) {
                node.val++;
                return reverse(head);
            }
            node.val = 0;
            prev = node;
            node = node.next;
        }
        prev.next = new ListNode(1);
        return reverse(head);
    }
    
    private ListNode reverse(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}