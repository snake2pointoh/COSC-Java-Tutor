package src.week17;

public class ThreadTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                System.out.printf("Thread T1 is at %d\n", i);
            }
        });

        Thread t2 = new Thread(new MyRunnable("t2"));

//        t2.start();

        Thread t3 = new Thread(ThreadTest::threadMethod);

        t3.start();

//        while (t2.isAlive()) {
//            System.out.println("t2 is alive");
//        }

//        t1.start();
//
//        try {
//            t1.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
        for (int i = 0; i < 10; i++) {
            System.out.printf("Main is at %d\n", i);
        }


    }

    public static void threadMethod() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("thread method is at %d\n", i);
        }
    }
}
