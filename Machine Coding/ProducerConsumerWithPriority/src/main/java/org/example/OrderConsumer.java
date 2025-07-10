package org.example;

class OrderConsumer implements Runnable {
    private final OrderDispatcher dispatcher;

    public OrderConsumer(OrderDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    @Override
    public void run() {
        while (true) {
            Order order = dispatcher.getNextOrder();
            if (order != null) {
                processOrder(order);
            } else {
                try {
                    Thread.sleep(100); // avoid tight loop
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            /*
                Thread.sleep(100);

                Slows down the loop a bit (waits 100 milliseconds).

                Reduces CPU usage when the queue is empty.

                Allows time for new orders to come in.

                The catch block handles interruption properly:

                java
                Copy
                Edit
                Thread.currentThread().interrupt(); // restore interrupt flag
                break; // exit the loop gracefully
                This means:

                If the thread is interrupted (e.g., during shutdown), it stops cleanly instead of crashing or running forever.

             */
        }
    }

    private void processOrder(Order order) {
        System.out.println(Thread.currentThread().getName() +
                " processed " + order.getUserType() +
                " order ID: " + order.getId());

        try {
            Thread.sleep(500); // simulate work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}