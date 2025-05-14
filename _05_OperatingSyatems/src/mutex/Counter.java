package mutex;

import java.util.concurrent.locks.ReentrantLock;

/*
* Mutex implementation using
* ReentrantLock
*/
public class Counter {
    private int value;
    private ReentrantLock lock;

    public Counter() {
        this.value = 0;
        lock = new ReentrantLock();
    }

    public void increment() {
        lock.lock();
        try {
            value++;
            System.out.println("Incremented By: " + Thread.currentThread().getName());
            System.out.println("Value: " + value);
        } finally {
            lock.unlock();
        }
    }
}

/*
 * Mutex implementation
 */

/*
*/
