package mutex;

/*
 * This class uses concrete Mutex class implemented within the same package.
 * The mutex class is implemented usin synchronized keyword, wait and notify methods.
 */

public class MutexCounter {
    private int value;
    private Mutex mutex;

    public MutexCounter() {
        this.value = 0;
        this.mutex = new Mutex();
    }

    public void increment() {
        // acquire section
        mutex.lock();
        try {
            // critical section
            value++;
            System.out.println("Value: " + value);
        } finally {
            // release section
            mutex.unlock();
        }
    }

}
