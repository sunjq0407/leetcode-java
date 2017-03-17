/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode node = head;
        RandomListNode prev = new RandomListNode(0);
        while(node != null) {
            RandomListNode copy = new RandomListNode(node.label);
            map.put(node, copy);
            node = node.next;
            prev.next = copy;
            prev = copy;
        }
        node = head;
        for(RandomListNode tmp : map.keySet())
            map.get(tmp).random = map.get(tmp.random);
        return map.get(head);
    }
}