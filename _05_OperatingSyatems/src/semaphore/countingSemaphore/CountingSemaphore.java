package semaphore.countingSemaphore;
/*
* This class is the implementation of counting semaphore.
* It takes number of threads allowed to enter into critical section
* as constructor parameter. */
public class CountingSemaphore {

    private int permits;

    public CountingSemaphore(int initialPermits) {
        if (permits < 0) throw new IllegalArgumentException("Permits must be >= 0");
        this.permits = initialPermits;
    }

    public synchronized void acquire() throws InterruptedException {
        while (permits == 0)
            wait();
        permits--;
    }

    public synchronized void release () {
        permits++;
        notify();
    }
}
