package org.example;

public class FixedThreadPoolTest {
    public static void main(String[] args) {
        FixedThreadPool threadPool = new FixedThreadPool(6);

        for (int i = 0; i < 10; i++) {
            final int taskId = i;

            Runnable task = new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " is executing task " + taskId);
                    try {
                        Thread.sleep(1000); // Simulate work
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            };

            threadPool.submit(task);
        }

        // Give time for threads to finish
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        threadPool.shutdown();
    }
}