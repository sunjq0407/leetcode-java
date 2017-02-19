/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyS = new ListNode(0);
        ListNode headS = dummyS;
        ListNode dummyL = new ListNode(0);
        ListNode headL = dummyL;
        while(head != null) {
            if(head.val < x) {
                headS.next = head;
                headS = headS.next;
            } else {
                headL.next = head;
                headL = headL.next;
            }
            head = head.next;
        }
        headL.next = null;
        headS.next = dummyL.next;
        return dummyS.next;
    }
}