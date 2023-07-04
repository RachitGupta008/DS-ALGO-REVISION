class LRUCache {
    class Node {
        int key, val;
        Node prev, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Map<Integer, Node> map;
    private Node head, tail;
    private int capacity, size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>();

        // Initialize dummy nodes
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            moveToHead(node);
        } else {
            if (size == capacity) {
                removeTail();
                size--;
            }
            Node newNode = new Node(key, value);
            addNode(newNode);
            map.put(key, newNode);
            size++;
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        size--;
    }

    private void addNode(Node node) {
        node.next = head.next;
        head.next.prev = node;

        node.prev = head;
        head.next = node;

        size++;
    }

    private void removeTail() {
        Node lastNode = tail.prev;
        removeNode(lastNode);
        map.remove(lastNode.key);
    }
}
