/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode prev = new ListNode(0);
        int carry = 0;
        while(!(l1==null && l2==null)) {
            int sum = carry;
            if(l1 != null) sum += l1.val;
            if(l2 != null) sum += l2.val;
            ListNode cur = new ListNode(sum % 10);
            carry = sum / 10;
            if(head == null) head = cur;
            prev.next = cur;
            prev = cur;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry != 0) prev.next = new ListNode(carry);
        return head;
    }
}