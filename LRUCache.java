public class LRUCache {
    
    private class Node {
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    Node head;
    Node tail;
    int size;
    int cap;
    Map<Integer, Node> map;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        size = 0;
        cap = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        moveToHead(map.get(key));
        return map.get(key).val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            map.get(key).val = value;
            moveToHead(map.get(key));
            return;
        }
        Node node = new Node(key, value);
        map.put(key, node);
        if(head == null) {
            head = node;
            tail = node;
            size ++;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
        if(++size > cap) evict();
    }
    
    private void moveToHead(Node node) {
        if(head == node) return;
        node.prev.next = node.next;
        if(tail == node) tail = node.prev;
        else node.next.prev = node.prev;
        head.prev = node;
        node.next = head;
        head = node;
        node.prev = null;
    }
    
    private void evict() {
        size --;
        map.remove(tail.key);
        tail = tail.prev;
        tail.next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */