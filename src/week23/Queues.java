package src.week23;


import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Queues {
    static ArrayBlockingQueue<Integer> arrayQueue = new ArrayBlockingQueue<>(50);

    public static void main(String[] args) {
        Thread addThread = new Thread(Queues::addQueueThread);
        Thread countThread = new Thread(Queues::countQueueThread);

        countThread.start();
        addThread.start();

        int execThreads = 2;
        ExecutorService excutors = Executors.newFixedThreadPool(execThreads);
        for (int i = 0; i < execThreads; i++) {
            excutors.execute(Queues::consumeQueueThread);
        }
    }

    public static void consumeQueueThread() {
        while (true) {
            try {
                Integer value = arrayQueue.poll();

                if(value != null) {
                    System.out.printf("Value: %d * 2 is: %d\n", value, value * 2);
                }

                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addQueueThread() {
        while (true) {
            try {

                Random rand = new Random();
                arrayQueue.put(rand.nextInt(1,101));

                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void countQueueThread() {
        while (true) {
            System.out.println("Count: " + arrayQueue.size());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
