package semaphore.ThreadPoolUsingSemaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreThreadPoolExample {
    private static final int MAX_CONCURRENT_TASK = 3;
    private static final Semaphore semaphore = new Semaphore(MAX_CONCURRENT_TASK);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 11; i++) {
            int taskId = i;
            executorService.submit(() -> runTask(taskId));
        }

        executorService.shutdown();
        try{
            if(executorService.awaitTermination(10, TimeUnit.SECONDS)){
                System.out.println("Task did not finished in time.");
                executorService.shutdown();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void runTask(int taskId) {
        try {
            System.out.println("Task " + taskId + " need premission.");
            semaphore.acquire();
            System.out.println("Task " + taskId + " got permission.");
            TimeUnit.MILLISECONDS.sleep(3000);
            System.out.println("Task " + taskId + " completed.");

        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }finally {
            semaphore.release();
        }
    }
}
