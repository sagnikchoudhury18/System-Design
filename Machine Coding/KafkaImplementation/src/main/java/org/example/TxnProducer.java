package org.example;

public class TxnProducer {
    private final Broker broker;

    public TxnProducer(Broker broker) {
        this.broker = broker;
    }

    public void sendTransaction(String topicName, String txnPayload) {
        Topic topic = broker.getOrCreateTopic(topicName);
        topic.publish(new Message(txnPayload));
        System.out.println("TxnProducer sent: " + txnPayload + " to topic: " + topicName);
    }
}
