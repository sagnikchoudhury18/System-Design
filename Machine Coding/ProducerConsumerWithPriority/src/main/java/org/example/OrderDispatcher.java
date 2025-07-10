package org.example;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

class OrderDispatcher {
    private final Queue<Order> primeQueue = new ConcurrentLinkedQueue<>();
    private final Queue<Order> normalQueue = new ConcurrentLinkedQueue<>();
    private int primeCounter = 0;
    private static final int PRIME_LIMIT = 3;

    public void addOrder(Order order) {
        if ("PRIME".equalsIgnoreCase(order.getUserType())) {
            primeQueue.add(order);
        } else {
            normalQueue.add(order);
        }
    }

    public synchronized Order getNextOrder() {
        if (primeCounter < PRIME_LIMIT && !primeQueue.isEmpty()) {
            primeCounter++;
            return primeQueue.poll();
        } else if (!normalQueue.isEmpty()) {
            primeCounter = 0; // reset after serving a normal user
            return normalQueue.poll();
        } else if (!primeQueue.isEmpty()) {
            return primeQueue.poll();
        } else {
            return null; // both queues empty
        }
    }
}
