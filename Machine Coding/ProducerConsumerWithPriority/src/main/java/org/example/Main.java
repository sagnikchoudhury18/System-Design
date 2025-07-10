package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        OrderDispatcher dispatcher = new OrderDispatcher();
        ExecutorService executor = Executors.newFixedThreadPool(3); // 3 workers

        // Start consumers
        for (int i = 0; i < 3; i++) {
            executor.submit(new OrderConsumer(dispatcher));
        }

        // Simulate orders coming in
        Runnable orderProducer = () -> {
            String[] userTypes = {"PRIME", "NORMAL"};
            for (int i = 0; i < 50; i++) {
                String type = userTypes[i % 4 == 0 ? 1 : 0]; // 3 PRIME : 1 NORMAL
                Order order = new Order(type);
                dispatcher.addOrder(order);
                System.out.println("Added " + type + " order ID: " + order.getId());

                try {
                    Thread.sleep(200); // new order every 200ms
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        new Thread(orderProducer).start();
    }
}
