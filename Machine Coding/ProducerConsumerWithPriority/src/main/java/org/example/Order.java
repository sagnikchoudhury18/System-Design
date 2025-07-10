package org.example;

import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class Order {
    private static final AtomicInteger idGenerator = new AtomicInteger(0);
    private final int id;
    private final String userType; // "PRIME" or "NORMAL"

    public Order(String userType) {
        this.id = idGenerator.incrementAndGet();
        this.userType = userType;
    }

    public int getId() {
        return id;
    }

    public String getUserType() {
        return userType;
    }
}