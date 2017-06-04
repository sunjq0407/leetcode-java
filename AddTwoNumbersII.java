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
        int len1 = 0;
        int len2 = 0;
        ListNode head = l1;
        while(head != null) {
            len1++;
            head = head.next;
        }
        head = l2;
        while(head != null) {
            len2++;
            head = head.next;
        }
        if(len2 > len1) {
            head = l1;
            l1 = l2;
            l2 = head;
            int tmp = len1;
            len1 = len2;
            len2 = tmp;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        ListNode prev = dummy;
        for(int i = 0; i < len1 - len2; i++) {
            if(l1.val != 9) prev = l1;
            l1 = l1.next;
        }
        while(l1 != null) {
            int carry = (l1.val + l2.val) / 10;
            l1.val = (l1.val + l2.val) % 10;
            while(carry == 1 && prev != l1) {
                prev.val = (prev.val + 1) % 10;
                prev = prev.next;
            }
            if(l1.val != 9) prev = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        return dummy.val == 0 ? dummy.next : dummy;
    }
}