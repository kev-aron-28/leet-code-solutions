package common;

import java.util.HashMap;
import java.util.Map;

// put(key, value)
// must both be O(1)
// When capacity is exceeded remove the least Reacently Used item

// Combine HashMap + Doubly Linked LIst

public class LRUCache {
    class Node {
        int key;
        int value;

        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    private int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);

        this.cache = new HashMap<>(capacity);
        
        head.next = tail;
        tail.prev = head;
        
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    } 

    private void insert(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);

        remove(node);
        insert(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);

            node.value = value;

            remove(node);
            insert(node);

            return;
        }

        Node node = new Node(key, value);
        cache.put(key, node);

        insert(node);

        if (cache.size() > capacity) {
            Node lru = tail.prev;

            remove(lru);

            cache.remove(lru.key);
        }
    }
}
