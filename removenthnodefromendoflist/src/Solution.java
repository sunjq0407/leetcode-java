/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;
        ListNode rmv = head;
        ListNode tmp = head;
        int i = 0;
        while (i<n) {
            if ((tmp = tmp.next) != null) i++;
            else return head.next;
        }
        while (tmp.next != null){
            tmp = tmp.next;
            rmv = rmv.next;
        }
        rmv.next = rmv.next.next;
        return head;
    }
}