class Node {
	int key;
	int value;
	Node next;
	Node prev;

	Node () {
		this.key = 0;
        this.value = 0;
        this.prev = null;
        this.next = null;
	}

	Node (int key, int value) {
		this.key = key;
		this.value = value;
        this.prev = null;
        this.next = null;
	}

	void updateValue (int value) {
		this.value = value;
	}
}

class LRUCache {
    
    Node head;
	Node tail;
	int size;
	HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        head = new Node();
		tail = new Node();
		
        head.next = tail;
		tail.prev = head;
		
        size = capacity;
		map = new HashMap<>();
    }
    
    void addFront(Node node) {
		Node temp = head.next;
		head.next = node;
		node.prev = head;
		node.next = temp;
		temp.prev = node;
	}

	void removeNode(Node node) {
		Node prevNode = node.prev;
		Node nextNode = node.next;
		
        prevNode.next = nextNode;
		nextNode.prev = prevNode;
		
        node.next = null;
		node.prev = null;
	}

	void moveToFront(Node node) {
		removeNode(node);
		addFront(node);
	}
    
    public int get(int key) {
        if (map.containsKey(key) == true) {
			Node node = map.get(key);
			moveToFront(node);
			return node.value;
		} else {
			return -1;
		}
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key) == true) {
			// updating
			Node node = map.get(key);
			node.updateValue(value);
			moveToFront(node);
		} else {
			Node node = new Node(key, value);
			if (map.size() == size) {
				Node LRU_Node = tail.prev;
				removeNode(LRU_Node);
				map.remove(LRU_Node.key);
			} 
			addFront(node);
			map.put(key, node);
		}
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */