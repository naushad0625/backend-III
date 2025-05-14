package mutex;

/*
* This is a mutex implementation.
* This class uses synchronized keyword
* wait() and notify() methods.
* */
public class Mutex {
    private boolean available = true;
    private Thread ownerThread = null;

    public synchronized void lock() {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        available = false;
        System.out.println("Locked by: " + Thread.currentThread().getName());
        ownerThread = Thread.currentThread();
    }

    public synchronized void unlock () {
        if (Thread.currentThread() != ownerThread) {
            throw new IllegalMonitorStateException("Current thread does not hold the lock");
        }
        available = true;
        System.out.println("Released by: " + Thread.currentThread().getName());
        ownerThread = null;
        notify();

    }

}
