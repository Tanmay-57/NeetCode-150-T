class Node {
    int key;
    int value;

    Node next;
    Node prev;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    HashMap<Integer, Node> cache = new HashMap<>();
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            addToFront(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            remove(node);
            addToFront(node);
        } else {
            Node node = new Node(key, value);
            cache.put(key, node);
            addToFront(node);

            if (cache.size() > capacity) {
                Node temp = tail.prev;
                cache.remove(temp.key);
                remove(temp);
            }
        }
    }

    void remove(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    void addToFront(Node node) {
        Node temp = head.next;
        node.prev = head;
        head.next = node;
        node.next = temp;
        temp.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
