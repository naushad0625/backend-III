package rwmutex;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TemparatureExample {
    public static void main(String[] args) {
        Temparature temparature = new Temparature();
        ExecutorService executorService = Executors.newFixedThreadPool(30);

        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> temparature.fetch());
        }

        for (int i = 0; i < 3; i++) {
            executorService.submit(() -> temparature.update(20 + (Math.random() * (50 - 20))));
        }

        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> temparature.fetch());
        }



        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(50, TimeUnit.SECONDS)){
                System.err.println("Tasks didn't finish in time.");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
