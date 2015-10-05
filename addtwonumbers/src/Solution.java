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
        ListNode tmp = null;
        ListNode head = new ListNode((l1.val+l2.val)%10);
        int carry = (l1.val+l2.val)/10;
        l1 = l1.next;
        l2 = l2.next;
        ListNode prev = head;
        while (l1!=null||l2!=null||carry!=0) {
            tmp = new ListNode(carry);
            if (l1!=null) {
                tmp.val += l1.val;
                l1 = l1.next;
            }
            if (l2!=null) {
                tmp.val += l2.val;
                l2 = l2.next;
            }
            carry = tmp.val/10;
            tmp.val %= 10;
            prev.next = tmp;
            prev = prev.next;
        }
        return head;
    }
}