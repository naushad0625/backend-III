package mutex;

public class MutexExecutor {
    public static void main(String[] args) {

        // Using ReentrantLock Muted
        //Counter counter = new Counter();

        // Using self implemented mutex
         MutexCounter counter = new MutexCounter();

        Thread t1 = new Thread(() -> counter.increment());
        Thread t2 = new Thread(() -> counter.increment());
        Thread t3 = new Thread(() -> counter.increment());

        t1.setName("T1");
        t2.setName("T2");
        t3.setName("T3");

        t1.start();
        t2.start();
        t3.start();

        try{
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }


    }
}
