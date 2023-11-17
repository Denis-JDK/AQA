package multitheard.count_down_latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsWaitCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 4; i++) {
            executorService.submit(new CountProcessor(i,countDownLatch));
        }
        executorService.shutdown();

        for (int i = 0; i < 3; i++) {
                Thread.sleep(2000);

            countDownLatch.countDown();
        }


    }
}

class CountProcessor implements Runnable{
    private int id;
    private CountDownLatch countDownLatch;

    public CountProcessor(int id, CountDownLatch countDownLatch) {
        this.id = id;
        this.countDownLatch = countDownLatch;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Thread " + id + " is await");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread " + id + " is processed");
    }
}




