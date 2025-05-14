package semaphore.countingSemaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountingSemaphoreExample {
    private static final CountingSemaphore semaphore = new CountingSemaphore(3);
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 11; i++) {
            int taskId = i;
            executorService.submit(() -> runTask(taskId));
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(20, TimeUnit.SECONDS)){
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
