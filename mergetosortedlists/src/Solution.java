/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tmp1 = l1, tmp2 = l2, ret = null, head = null;
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            ret = tmp1;
            tmp1 = tmp1.next;
        }
        else {
            ret = tmp2;
            tmp2 = tmp2.next;
        }
        head = ret;
        while (tmp1!=null&&tmp2!=null) {
            if (tmp1.val <= tmp2.val) {
                ret.next = tmp1;
                ret = ret.next;
                tmp1 = tmp1.next;
            }
            else {
                ret.next = tmp2;
                ret = ret.next;
                tmp2 = tmp2.next;
            }
        }
        if (tmp1 == null) ret.next = tmp2;
        if (tmp2 == null) ret.next = tmp1;
        return head;
    }
}