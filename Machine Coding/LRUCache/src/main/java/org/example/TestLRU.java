package org.example;

public class TestLRU {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2); // Capacity = 2

        cache.put(1, 10);
        cache.put(2, 20);
        System.out.println(cache.get(1)); // returns 10

        cache.put(3, 30); // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)

        cache.put(4, 40); // evicts key 1
        System.out.println(cache.get(1)); // returns -1
        System.out.println(cache.get(3)); // returns 30
        System.out.println(cache.get(4)); // returns 40
    }
}