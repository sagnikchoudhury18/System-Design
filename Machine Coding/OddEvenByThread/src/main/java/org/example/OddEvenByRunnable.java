package org.example;

public class OddEvenByRunnable {

    private static final int MAX = 10;
    private static final Object lock = new Object();
    private static boolean isOddTurn = false; // false means even's turn, true means odd's turn

    static class OddRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= MAX; i += 2) {
                synchronized (lock) {
                    while (!isOddTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println("Odd Thread: " + i);
                    isOddTurn = false;
                    lock.notify();
                }
            }
        }
    }

    static class EvenRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 2; i <= MAX; i += 2) {
                synchronized (lock) {
                    while (isOddTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println("Even Thread: " + i);
                    isOddTurn = true;
                    lock.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread oddThread = new Thread(new OddRunnable());
        Thread evenThread = new Thread(new EvenRunnable());

        // Start both threads
        evenThread.start();
        oddThread.start();
    }
}