package org.example;

import java.util.concurrent.ConcurrentHashMap;

public class Broker {
    private final ConcurrentHashMap<String, Topic> topics = new ConcurrentHashMap<>();

    public Topic getOrCreateTopic(String topicName) {
        return topics.computeIfAbsent(topicName, Topic::new);
    }
}
