package multitheard.count_down_latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatchDown = new CountDownLatch(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Processor processor = new Processor(countDownLatchDown);
        Thread thread = new Thread(processor);

        thread.start();


        for (int i = 0; i < 3; i++) {
            executorService.submit(new Processor(countDownLatchDown));
        }
        executorService.shutdown();
        countDownLatchDown.await(); //поток майн ждет пока три раза вызовется метод countDownLatch.countDown(); и защелка освободит проход.
        System.out.println("Latch has been opened, main thread is proceeding");



    }
}

class Processor implements Runnable{
    private CountDownLatch countDownLatch;

    public Processor(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        countDownLatch.countDown();

    }
}
