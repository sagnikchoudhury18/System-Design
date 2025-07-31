package org.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Topic {
    private final String name;
    private final BlockingQueue<Message> messages = new LinkedBlockingQueue<>();

    public Topic(String name) {
        this.name = name;
    }

    public void publish(Message message) {
        messages.add(message);
    }

    public Message consume() throws InterruptedException {
        return messages.take(); // blocking
    }

    public String getName() {
        return name;
    }
}
