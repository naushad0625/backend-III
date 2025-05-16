package ProducerConsumer;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();

        Thread t1 = new Thread(() -> {
            while (true) {
                pc.produce();
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                pc.consume();
            }
        });

        t1.setName("Producer");
        t2.setName("Consumer");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
