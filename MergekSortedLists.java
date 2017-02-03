/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for(ListNode node : lists)
            if(node != null) heap.offer(node);
        while(!heap.isEmpty()) {
            ListNode node = heap.poll();
            if(node.next != null) heap.offer(node.next);
            head.next = node;
            head = head.next;
        }
        return dummy.next;
    }
}