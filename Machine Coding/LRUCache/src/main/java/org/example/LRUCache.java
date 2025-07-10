package org.example;

import java.util.HashMap;

public class LRUCache {
    private final int capacity;
    private final HashMap<Integer, Node> cache;
    private final DoublyLinkedList dll;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.dll = new DoublyLinkedList();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        Node node = cache.get(key);
        dll.moveToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node existing = cache.get(key);
            existing.value = value;
            dll.moveToFront(existing);
        } else {
            if (cache.size() == capacity) {
                Node lru = dll.removeTail(); // remove LRU
                cache.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            dll.addToFront(newNode);
            cache.put(key, newNode);
        }
    }

    // Doubly Linked List Node
    private static class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    // Doubly Linked List Helper Class
    private static class DoublyLinkedList {
        private final Node head, tail;

        public DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public void addToFront(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        public void moveToFront(Node node) {
            remove(node);
            addToFront(node);
        }

        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public Node removeTail() {
            Node lru = tail.prev;
            remove(lru);
            return lru;
        }
    }
}