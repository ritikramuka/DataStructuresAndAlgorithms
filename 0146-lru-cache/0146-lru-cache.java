class LRUCache {
    class Node {
        int key;
        int val;

        Node next;
        Node prev;

        Node () {
            this.key = 0;
            this.val = 0;
            this.next = null;
            this.prev = null;
        }

        Node (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private void addNode(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        Node prv = node.prev;
        Node nxt = node.next;

        prv.next = nxt;
        nxt.prev = prv;
    }

    private void moveToFront(Node node) {
        removeNode(node);
        addNode(node);
    }

    HashMap<Integer, Node> cache;
    Node head, tail;
    int cap;

    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
        cap = capacity;
    }
    
    public int get(int key) {
        Node node = cache.get(key);

        if (node == null) {
            return -1;
        } else {
            moveToFront(node);
            return node.val;
        }
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);

        if (node != null) {
            node.val = value;
            moveToFront(node);
        } else {
            Node newNode = new Node();
            newNode.key = key;
            newNode.val = value;
            if (cache.size() == cap) {
            int LRU_Key = tail.prev.key;
            Node LRU_Node = cache.remove(LRU_Key);
            removeNode(LRU_Node);
            }
            cache.put(key, newNode);
            addNode(newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */