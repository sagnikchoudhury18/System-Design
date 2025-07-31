package org.example;

public class TxnListener implements Runnable {
    private final String listenerId;
    private final Topic topic;

    public TxnListener(String listenerId, Topic topic) {
        this.listenerId = listenerId;
        this.topic = topic;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message message = topic.consume();
                System.out.println("[" + listenerId + "] Processed Txn: " + message.getContent());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}