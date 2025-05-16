package ProducerConsumer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ProducerConsumer {
    private final int size = 10;
    private final double[] buffer = new double[size];
    private final String outputFile = "data.txt";
    private int in = 0, out = 0;

    private Semaphore empty = new Semaphore(size);
    private Semaphore full = new Semaphore(0);
    private Semaphore mutex = new Semaphore(1);

    public void produce() {
        try {
            empty.acquire();
            mutex.acquire();

            buffer[in] = Math.random() * 100;
            System.out.println("Producer produced: " + buffer[in]);
            in = (in + 1) % size;
            mutex.release();
            full.release();

            long timeToSleep = (long) (Math.random() * 5000);
            TimeUnit.MILLISECONDS.sleep(timeToSleep);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void consume() {
        try {
            full.acquire();
            mutex.acquire();

            double valueToConsume = buffer[out];
            out = (out + 1) % size;
            System.out.println("Consumer consumed: " + valueToConsume);

            mutex.release();
            empty.release();

            long timeToSleep = (long) (Math.random() * 5000);
            TimeUnit.MILLISECONDS.sleep(timeToSleep);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
