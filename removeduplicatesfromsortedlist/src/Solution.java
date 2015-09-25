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
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode tmp = head, node = head;
        while (node!=null) {
            while (node!=null&&node.val==tmp.val) node = node.next;
            tmp.next = node;
            tmp = node;
            if (node!=null) node = node.next;
        }
        return head;
    }
}