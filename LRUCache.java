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
    
    int capacity;
    int size;
    Node head;
    Node tail;
    Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            head.next.prev = node;
            node.next = head.next;
            head.next = node;
            node.prev = head;
            return node.val;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            head.next.prev = node;
            node.next = head.next;
            head.next = node;
            node.prev = head;
            return;
        }
        if(size == capacity) {
            Node evct = tail.prev;
            evct.prev.next = tail;
            tail.prev = evct.prev;
            cache.remove(evct.key);
            size--;
        }
        size++;
        Node node = new Node(key, value);
        cache.put(key, node);
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */