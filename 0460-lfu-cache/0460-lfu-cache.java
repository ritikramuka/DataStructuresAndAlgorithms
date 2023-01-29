class Node {
    int val;
    int key;
    int freq;

    Node next;
    Node prev;

    Node (int key, int val) {
        this.key = key;
        this.val = val;
        this.freq = 1;
        this.next = null;
        this.prev = null;
    }

    Node () {
        this.key = 0;
        this.val = 0;
        this.freq = 0;
        this.next = null;
        this.prev = null;
    }
}

class DoubleLinkedList {
    Node head;
    Node tail;
    int size;

    DoubleLinkedList() {
        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;

        size = 0;
    }

    public void addNode (Node node) {
        // add node to front after head

        Node A = head.next;
        
        node.next = A;
        A.prev = node;

        head.next = node;
        node.prev = head;

        size++;
    }

    public void removeNode (Node node) {
        // remove a node from DLL

        Node A = node.prev;
        Node B = node.next;

        A.next = B;
        B.prev = A;

        node.next = null;
        node.prev = null;

        size--;
    }
}

class LFUCache {
    HashMap<Integer, Node> map1;
    HashMap<Integer, DoubleLinkedList> map2;
    int maxCapacity;
    int size;
    int minFreq;

    private void updateNode (Node node) {
        DoubleLinkedList list = map2.get(node.freq);
        list.removeNode(node);
        if (node.freq == minFreq && list.size == 0) {
            minFreq++;
        }

        node.freq++;
        DoubleLinkedList newList = map2.getOrDefault(node.freq, new DoubleLinkedList());
        newList.addNode(node);
        map2.put(node.freq, newList);
    }

    public LFUCache(int capacity) {
        map1 = new HashMap<>();
        map2 = new HashMap<>();

        maxCapacity = capacity;
        size = 0;
        minFreq = 1;
    }
    
    public int get(int key) {
        if (map1.containsKey(key) == false) {
            return -1;
        } else {
            Node node = map1.get(key);
            int val = node.val;
            updateNode(node);
            return val;
        }
    }
    
    public void put(int key, int value) {
        if (maxCapacity == 0) {
            return;
        }

        if (map1.containsKey(key) == true) {
            Node node = map1.get(key);
            node.val = value;
            updateNode(node);
        } else {
            Node node = new Node (key, value);

            if (size == maxCapacity) {
                DoubleLinkedList list = map2.get(minFreq);
                Node LRU_Node = list.tail.prev;

                list.removeNode(LRU_Node);
                map1.remove(LRU_Node.key);
                size--;
            }

            minFreq = 1;
            DoubleLinkedList newList = map2.getOrDefault(minFreq, new DoubleLinkedList());
            newList.addNode(node);
            map2.put(minFreq, newList);

            map1.put(key, node);

            size++;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */