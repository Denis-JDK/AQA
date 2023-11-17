package multitheard;



public class MultuThreds {
    public static void main(String[] args) {
        Counter c = new Counter();

        Thread t1 = new Thread(new TestThread(c), "name1");
        Thread t2 = new Thread(new TestThread(c), "name2");

        t1.start();
        t2.start();
    }

}

    class TestThread implements Runnable{
        private Counter c;

         TestThread(Counter c) {
            this.c = c;

            char $f = 2;

             System.out.printf("%c", $f);
        }


        @Override
        public void run() {
            synchronized (c) {
            //    c.getTest();
                try {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(Thread.currentThread().getName() + ": " + c.count);
                        c.count++;
                        Thread.sleep(300);
                    }
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }
    }

