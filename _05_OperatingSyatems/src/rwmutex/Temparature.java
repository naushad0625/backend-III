package rwmutex;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.*;

public class Temparature {
    private double value;
    private ReentrantReadWriteLock lock;

    public Temparature() {
        this.value = 35.5;
        lock = new ReentrantReadWriteLock(true);
    }

    public void update (double value) {
        WriteLock writeLock = lock.writeLock();
        writeLock.lock();
        try{
            this.value = value;
            System.out.println("Temperature updated to : " + value );
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public double fetch() {
        ReadLock readLock = lock.readLock();
        readLock.lock();
        try{
            TimeUnit.SECONDS.sleep(5);
            System.out.println("Read Lock acquired by: " + Thread.currentThread().getName());
            System.out.println("Temparature: " + value);
            return value;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            readLock.unlock();
        }

    }
}
