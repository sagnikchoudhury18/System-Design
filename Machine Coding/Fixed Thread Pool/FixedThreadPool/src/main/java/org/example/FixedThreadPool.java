package org.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FixedThreadPool {
    private final BlockingQueue<Runnable> taskQueue;
    private final WorkerThread[] workers;
    private volatile boolean isShutdown = false;

    public FixedThreadPool(int numberOfThreads) {
        taskQueue = new LinkedBlockingQueue<>();
        workers = new WorkerThread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            workers[i] = new WorkerThread("Worker-" + i);
            workers[i].start();
        }
    }

    public void submit(Runnable task) throws IllegalStateException {
        if (!isShutdown) {
            taskQueue.offer(task);
        } else {
            throw new IllegalStateException("ThreadPool has been shutdown");
        }
    }

    public void shutdown() {
        isShutdown = true;
        for (WorkerThread worker : workers) {
            worker.interrupt(); // To unblock any waiting thread
        }
    }

    private class WorkerThread extends Thread {
        public WorkerThread(String name) {
            super(name);
        }

        public void run() {
            while (!isShutdown || !taskQueue.isEmpty()) {
                try {
                    Runnable task = taskQueue.take(); // waits if empty
                    task.run();
                } catch (InterruptedException e) {
                    // Thread interrupted for shutdown
                    if (isShutdown) break;
                }
            }
        }
    }
}