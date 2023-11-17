package multitheard;

public class Counter {
    public int count = 0;

    public synchronized void getTest(){

            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + count);
                count++;
            }

        }
}
