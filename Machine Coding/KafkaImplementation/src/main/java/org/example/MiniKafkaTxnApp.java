package org.example;

public class MiniKafkaTxnApp {
    public static void main(String[] args) {
        Broker broker = new Broker();
        TxnProducer producer = new TxnProducer(broker);
        Topic txnTopic = broker.getOrCreateTopic("txn-topic");

        // Start multiple listeners
        Thread listener1 = new Thread(new TxnListener("Listener-1", txnTopic));
        Thread listener2 = new Thread(new TxnListener("Listener-2", txnTopic));
        listener1.start();
        listener2.start();

        // Simulate producing transactions
        for (int i = 1; i <= 10; i++) {
            producer.sendTransaction("txn-topic", "TXN_" + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException ignored) {}
        }
    }

}
